package com.conveyal.datatools.editor.controllers.api;

import com.conveyal.gtfs.loader.Table;
import com.conveyal.gtfs.model.Entity;

import javax.sql.DataSource;

public class EditorControllerImpl extends EditorController {
    public EditorControllerImpl(String apiPrefix, Table table, DataSource dataSource){
        super(apiPrefix, table, dataSource);
        /** lets try an endpoint */
        get(apiPrefix + "secure/editor/number/:number", (req, res) -> {
                // Get the number from the request
                int number = Integer.parseInt(req.params(":number"));

                // Generate the file content
                String fileContent = "This is the content of file " + number;

                // Set the response type to "text/plain"
                res.type("text/plain");

                // Set the response content to the generated file content
                return fileContent;
            });
    }
}
