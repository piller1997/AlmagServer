package com.elamed.almag.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Nonnull;

/**
 * Interface for execution some actions with database.
 *
 * @param <R> Type of response.
 */
public interface Executable<R> {
    /**
     * Execites some actions with database.
     *
     * @param connection Connection to DB.
     * @return Some responce.
     * @throws SQLException SQL Exception that's throws when smth wrong in DB.
     */
    R execute(@Nonnull Connection connection) throws SQLException;
}
