package com.elamed.almag.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.elamed.almag.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Connector and executor of queries to DB.
 */
public abstract class AbstractDbConnector {
    private final String url;
    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * Creates {@link AbstractDbConnector} instance.
     *
     * @param properties Program's properties.
     */
    public AbstractDbConnector(@Nonnull final Properties properties) {
        Objects.requireNonNull(properties);
        url = "jdbc:sqlite:" + properties.getUrlDatabase();
    }

    /**
     * Connects and execute method, implemented in {@param lambda}.
     *
     * @param executable implementing {@link Executable} instance.
     * @param <T> Type of returning.
     * @return result of executing {@param executable}.
     * @throws SQLException SQL Exception.
     */
    protected <T> T connectAndExecute(@Nonnull final Executable<T> executable) throws SQLException {
        Objects.requireNonNull(executable);
        final Connection connection = connect();
        final T result;
        if (!connection.isClosed()) {
            result = executable.execute(connection);
        } else {
            result = null;
        }
        disconnect(connection);
        return result;
    }

    /**
     * Connects to database.
     *
     * @return Connection to database.
     * @throws SQLException Sql exception
     */
    @Nonnull
    protected Connection connect() throws SQLException {
        final Connection connection = DriverManager.getConnection(url);
        logger.debug("Database connected");
        return connection;
    }

    /**
     * Disconnects from database.
     *
     * @param connection connection for disconnecting.
     */
    protected void disconnect(@Nonnull final Connection connection) {
        Objects.requireNonNull(connection);
        try {
            connection.close();
        } catch (SQLException e) {
            logger.warn(e);
        }
    }
}
