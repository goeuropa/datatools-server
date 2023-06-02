package com.conveyal.gtfs;

import com.conveyal.gtfs.graphql.GTFSGraphQL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.introspection.IntrospectionQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.conveyal.datatools.common.utils.SparkUtils.logMessageAndHalt;
import static spark.Spark.get;
import static spark.Spark.post;
import com.conveyal.datatools.manager.controllers.api.PrzystanekD;
import com.conveyal.datatools.manager.controllers.api.PdfGenerator;

import com.google.gson.*;

/**
 * This Spark Controller contains methods to provide HTTP responses to GraphQL queries, including a query for the
 * GraphQL schema.
 */
public class GraphQLController {
    private static final Logger LOG = LoggerFactory.getLogger(GraphQLController.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * A Spark Controller that responds to a GraphQL query in HTTP GET query parameters.
     */
    public static Map<String, Object> getGraphQL (Request request, Response response) {

      //and other method too
      //getGraphQL();
        JsonNode varsJson = null;
        try {
            varsJson = mapper.readTree(request.queryParams("variables"));
        } catch (IOException e) {
            LOG.warn("Error processing variables", e);
            logMessageAndHalt(request, 400, "Malformed JSON");
        }
        String queryJson = request.queryParams("query");
        return doQuery(varsJson, queryJson, response);
    }
    public static Map<String, Object> getGraphQL2 (Request request, Response response)  {
        long startTime = System.currentTimeMillis();
        String query = "\n      query entityQuery($namespace: String, $id: Int) {\n        feed(namespace: $namespace) {\n          feed_id\n          feed_version\n          filename\n          routes (limit: -1, id: $id) {\n            id\n            \n        status\npublicly_visible\nroute_id\nroute_short_name\nroute_long_name\nagency_id\nroute_desc\nroute_type\nroute_sort_order\ncontinuous_pickup\ncontinuous_drop_off\nroute_url\nroute_color\nroute_text_color\nwheelchair_accessible\nroute_branding_url\n        tripPatterns: patterns (limit: -1) {\n          id\n          shape_id\n          pattern_id\n          route_id\n          direction_id\n          use_frequency\n          name\n          pattern_stops (limit: -1) {\n    id\n    stop_id\n    default_travel_time\n    default_dwell_time\n    stop_sequence\n    shape_dist_traveled\n    pickup_type\n    drop_off_type\n    timepoint\n    continuous_pickup\n    continuous_drop_off\n    stop_headsign\n  }\n          shape_points: shape (limit: -1) {\n    shape_pt_lon\n    shape_pt_lat\n    shape_pt_sequence\n    point_type\n    shape_dist_traveled\n  }\n        }\n      \n          }\n        }\n      }\n    ";

        Map<String, Object> variables = new HashMap<>();
variables.put("id", "7");
variables.put("namespace", "eflw_mvxfumemrobuxwnuklzdin");
/*
{data={feed=null}, errors=[{message=Exception while fetching data (/feed) : org.postgresql.util.PSQLException: Connection to localhost:5432 refused. Check that the hostname and port are correct and that the postmaster is accepting TCP/IP connections., locations=[{line=3, column=9}], path=[feed]}]}
datatools-server     | result:..
datatools-server     | ExecutionResultImpl{data={feed=null}, errors=[ExceptionWhileDataFetching{path=[feed]exception=java.lang.RuntimeException: org.postgresql.util.PSQLException: Connection to localhost:5432 refused. Check that the hostname and port are correct and that the postmaster is accepting TCP/IP connections.locations=[SourceLocation{line=3, column=9}]}], dataPresent=true, extensions=null}
*/

        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .variables(variables)
                .build();
        ExecutionResult result = GTFSGraphQL.getGraphQl().execute(executionInput);
        long endTime = System.currentTimeMillis();
        LOG.info("Query took {} msec", endTime - startTime);
        System.out.println("after query..");
        System.out.println(result.toSpecification());

        return result.toSpecification();
    }
    /**
     * A Spark Controller that responds to a GraphQL query in an HTTP POST body.
     */
    public static Map<String, Object> postGraphQL (Request req, Response response) {
        JsonNode node = null;
        try {
            node = mapper.readTree(req.body());
        } catch (IOException e) {
            LOG.warn("Error processing POST body JSON", e);
            logMessageAndHalt(req, 400, "Malformed JSON");
        }
        JsonNode vars = node.get("variables");
        String query = node.get("query").asText();
        return doQuery(vars, query, response);
    }

    /**
     * Execute a GraphQL query and return result that fully complies with the GraphQL specification.
     */
    private static Map<String, Object> doQuery (JsonNode varsJson, String queryJson, Response response) {
        long startTime = System.currentTimeMillis();
        if (varsJson == null && queryJson == null) {
            return getSchema(null, null);
        }
        // The graphiql app sends over this unparseable string while doing an introspection query.  Therefore this code
        // checks for it and sends an empty map in that case.
        Map<String, Object> variables = varsJson == null || varsJson.toString().equals("\"{}\"")
            ? new HashMap<>()
            : mapper.convertValue(varsJson, Map.class);
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(queryJson)
                .variables(variables)
                .build();
        ExecutionResult result = GTFSGraphQL.getGraphQl().execute(executionInput);
        long endTime = System.currentTimeMillis();
        LOG.info("Query took {} msec", endTime - startTime);

//hook
PdfGenerator pdf = new PdfGenerator();
//PrzystanekD p = pdf.generujKombus(number);

//  String databaseUrl = "jdbc:postgresql://postgres/dmtest";//
PrzystanekD p = new PrzystanekD();
//GraphQLController.initialize(GTFS.createDataSource(databaseUrl, null, null), apiPrefix);
System.out.println("Generating output3.pdf ( i dont know where it lies ), result.getData(): ");
System.out.println(result.getData().toString());
String jsonString = result.getData();
Gson gson = new Gson();
JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
JsonObject dataObject = jsonObject.getAsJsonObject("data");
JsonObject routesObject = dataObject.getAsJsonObject("routes");

JsonArray routesArray = routesObject.getAsJsonArray("routes");

String routeLongName = "";
String routeShortName = "";

for (JsonElement element : routesArray) {
JsonObject routeObject = element.getAsJsonObject();
int id = routeObject.get("id").getAsInt();

if (id == 7) {
routeLongName = routeObject.get("route_long_name").getAsString();
routeShortName = routeObject.get("route_short_name").getAsString();
break; // Exit the loop once the desired route is found
}
}
p.kierunek = routeLongName;
p.nazwa = routeShortName;
p.linia = routeShortName;
//GraphQLController.getGraphQL();

pdf.generujPrzystanek(p, "output3.pdf");
//endhook

        return result.toSpecification();
    }


    /**
     * A Spark Controller that returns the GraphQL schema.
     */
    static Map<String, Object> getSchema(Request req, Response res) {
        return GTFSGraphQL.getGraphQl().execute(IntrospectionQuery.INTROSPECTION_QUERY).toSpecification();
    }


    /**
     * Register Spark HTTP endpoints. API prefix should begin and end with "/", e.g. "/api/".
     */
    public static void initialize (DataSource dataSource, String apiPrefix) {
        LOG.info("Initialized GTFS GraphQL API at localhost:port{}", apiPrefix);
        if (dataSource == null) {
            throw new RuntimeException("Cannot initialize GraphQL endpoints. Data source must not be null.");
        }
        GTFSGraphQL.initialize(dataSource);
        get(apiPrefix + "graphql2", GraphQLController::getGraphQL2, mapper::writeValueAsString);
        get(apiPrefix + "graphql", GraphQLController::getGraphQL, mapper::writeValueAsString);
        post(apiPrefix + "graphql", GraphQLController::postGraphQL, mapper::writeValueAsString);
        get(apiPrefix + "graphql/schema", GraphQLController::getSchema, mapper::writeValueAsString);
        post(apiPrefix + "graphql/schema", GraphQLController::getSchema, mapper::writeValueAsString);
    }
}
