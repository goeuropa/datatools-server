package com.conveyal.datatools.manager.controllers.api;

import com.conveyal.datatools.common.status.MonitorableJob;
import com.conveyal.datatools.common.utils.RequestSummary;
import com.conveyal.datatools.manager.DataManager;
import com.conveyal.datatools.manager.auth.Auth0UserProfile;
import com.conveyal.datatools.manager.models.JsonViews;
import com.conveyal.datatools.manager.utils.JobUtils;
import com.conveyal.datatools.manager.utils.json.JsonManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.conveyal.datatools.common.utils.SparkUtils.logMessageAndHalt;
import static spark.Spark.get;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;

import java.io.*;
import spark.*;

import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

/**
 * Created by landon on 6/13/16. + cyan 2023-05-18
 */
public class StatusController {
    private static JsonManager<MonitorableJob.Status> json =
        new JsonManager<>(MonitorableJob.Status.class, JsonViews.UserInterface.class);

    /**
     * Admin API route to return active jobs for all application users.
     */
    private static Set<MonitorableJob> getAllJobsRoute(Request req, Response res) {
        Auth0UserProfile userProfile = req.attribute("user");
        if (!userProfile.canAdministerApplication()) {
            logMessageAndHalt(req, 401, "User not authorized to view all jobs");
        }
        return JobUtils.getAllJobs();
    }

    /**
     * Admin API route to return latest requests made to applications.
     */
    private static List<RequestSummary> getAllRequestsRoute(Request req, Response res) {
        Auth0UserProfile userProfile = req.attribute("user");
        if (!userProfile.canAdministerApplication()) {
            logMessageAndHalt(req, 401, "User not authorized to view all requests");
        }
        return DataManager.lastRequestForUser.values().stream()
            .sorted(Comparator.comparingLong(RequestSummary::getTime).reversed())
            .collect(Collectors.toList());
    }

    /**
     * API route that returns single job by ID from among the jobs for the currently authenticated user.
     */
    private static MonitorableJob getOneJobRoute(Request req, Response res) {
        String jobId = req.params("jobId");
        Auth0UserProfile userProfile = req.attribute("user");
        // FIXME: refactor underscore in user_id methods
        String userId = userProfile.getUser_id();
        return JobUtils.getJobById(userId, jobId, true);
    }

    /**
     * API route that cancels a single job by ID.
     */
    // TODO Add ability to cancel job. This requires some changes to how these jobs are executed. It appears that
    //  only scheduled jobs can be canceled.
//    private static MonitorableJob cancelJob(Request req, Response res) {
//        String jobId = req.params("jobId");
//        Auth0UserProfile userProfile = req.attribute("user");
//        // FIXME: refactor underscore in user_id methods
//        String userId = userProfile.getUser_id();
//        MonitorableJob job = getJobById(userId, jobId, true);
//        return job;
//    }

    /**
     * API route that returns a set of active jobs for the currently authenticated user.
     */
    public static Set<MonitorableJob> getUserJobsRoute(Request req, Response res) {
        Auth0UserProfile userProfile = req.attribute("user");
        // FIXME: refactor underscore in user_id methods
        String userId = userProfile.getUser_id();
        // Get a copy of all existing jobs before we purge the completed ones.
        return JobUtils.getJobsByUserId(userId, true);
    }

    public static void register (String apiPrefix) {

        get(apiPrefix + "secure/status/requests", StatusController::getAllRequestsRoute, json::write);
        // These endpoints return all jobs for the current user, all application jobs, or a specific job
        get(apiPrefix + "secure/status/jobs", StatusController::getUserJobsRoute, json::write);
        // FIXME Change endpoint for all jobs (to avoid overlap with jobId param)?
        get(apiPrefix + "secure/status/jobs/all", StatusController::getAllJobsRoute, json::write);
        get(apiPrefix + "secure/status/jobs/:jobId", StatusController::getOneJobRoute, json::write);
        // TODO Add ability to cancel job
//        delete(apiPrefix + "secure/status/jobs/:jobId", StatusController::cancelJob, json::write);
/** lets try an endpoint */
        get(apiPrefix + "secure/status/number/:number", (req, res) -> {
        // Get the number from the request
        int number = Integer.parseInt(req.params(":number"));

        // Generate the file content
        //String fileContent = "This is the number of file " + number;


	        PdfGenerator pdf = new PdfGenerator();
        PrzystanekD p = new PrzystanekD();
        p.nazwa = "Rondo Śródka";
        p.kierunek = "Małe Garbary";
        p.waznyod = "04-04-2023";
        p.linia = "582";

        p.odjazdy1[3][20] = "O";
        p.odjazdy1[3][40] = "O";
        p.odjazdy1[4][20] = "K";
        p.odjazdy1[15][20] = "O";

        p.odjazdy2[4][10] = "O";
        p.odjazdy2[4][50] = "O";
        p.odjazdy2[15][30] = "O";

        p.odjazdy3[12][20] = "O";
        p.odjazdy3[12][35] = "K";

        p.przystanki[0] = "Szymanowskiego";
        p.przystanki[1] = "Opienskiego";
        p.przystanki[2] = "Kurpińskiego";
        p.przystanki[3] = "Lechicka";
        p.przystanki[4] = "Os. Pod Lipami";
        p.przystanki[5] = "Armii Poznań";
        p.przystanki[6] = "Słowiańska";
        p.przystanki[7] = "Most Teatralny";
        p.przystanki[8] = "Rondo Kaponiera";
        p.przystanki[9] = "Dworzec Główny PKP";
        p.przystanki[10] = "Rynek Łazarski";
        p.przystanki[11] = "Hetmańska";
        p.przystanki[12] = "Rolna";
        p.przystanki[13] = "28 Czerwca 1956 r. ";
        pdf.generujPrzystanek(p,"output2.pdf");

        res.header("Content-Disposition", "attachment; filename=output2.pdf");
    res.type("application/pdf");

    // Write the file content to the response output stream
    try (InputStream is = new FileInputStream("output2.pdf")) {
        OutputStream os = res.raw().getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
    } catch (IOException e) {
        // Handle exception
    }

    // Return null to indicate that no further processing should be done
    return null;

        // Set the response content to the generated file content
        //return fileContent;TODO: if works or must return
    });
    }
}
