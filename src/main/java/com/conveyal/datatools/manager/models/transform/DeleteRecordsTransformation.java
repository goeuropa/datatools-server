package com.conveyal.datatools.manager.models.transform;

import com.conveyal.datatools.common.status.MonitorableJob;
import com.conveyal.datatools.manager.models.Snapshot;
import com.conveyal.datatools.manager.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static com.conveyal.datatools.manager.DataManager.GTFS_DATA_SOURCE;

/**
 * For now this is somewhat of just a demonstration/example for how to build create a {@link DbTransformation} subclass.
 * This feed transformation will operate on the namespace for the provided {@link FeedTransformTarget#snapshotId}.
 * It will delete all records in the specified table that match the WHERE clause created by the match field and values.
 */
public class DeleteRecordsTransformation extends DbTransformation {
    private static final Logger LOG = LoggerFactory.getLogger(DeleteRecordsTransformation.class);

    public static DeleteRecordsTransformation create(String table, String matchField, List<String> matchValues) {
        DeleteRecordsTransformation transformation = new DeleteRecordsTransformation();
        transformation.table = table;
        transformation.matchField = matchField;
        transformation.matchValues = matchValues;
        return transformation;
    }

    @Override
    public void transform(FeedTransformTarget target, MonitorableJob.Status status) {
        // Fetch the referenced snapshot to transform.
        Snapshot snapshot = Persistence.snapshots.getById(target.snapshotId);
        if (snapshot == null) {
            status.fail(String.format("Cannot find snapshot to transform (id=%s)", target.snapshotId));
            return;
        }
        // Create a new SQL connection, construct the SQL statement, execute and commit results.
        try (Connection connection = GTFS_DATA_SOURCE.getConnection()) {
            String deleteSql = String.format(
                "delete from %s.%s where %s in (%s)",
                snapshot.namespace,
                table,
                matchField,
                String.join(", ", Collections.nCopies(matchValues.size(), "?"))
            );
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            for (int i = 0; i < matchValues.size(); i++) {
                // Set string using one-based index.
                preparedStatement.setString(i + 1, matchValues.get(i));
            }
            LOG.info("SQL update: {}", preparedStatement.toString());
            int count = preparedStatement.executeUpdate();
            LOG.info("{} deleted {} records", this.getClass().getSimpleName(), count);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
