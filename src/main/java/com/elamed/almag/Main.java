package com.elamed.almag;

import java.io.IOException;

import com.elamed.almag.db.DbDao;
import com.elamed.almag.server.AlmagServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Server's program.
 */
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private Main() { }

    /**
     * Runs server's program.
     *
     * @param args CLI arguments.
     */
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                final Properties properties = new Properties(args[0]);
                final DbDao articlesDao = new DbDao(properties);
                final AlmagServer almagServer = new AlmagServer(properties, articlesDao);
                almagServer.start();
            } else {
                LOGGER.warn(
                        "Mandatory 1st argument is missing. Usage: program_name configuration_file");
            }
        } catch (IOException e) {
            LOGGER.warn(e);
        }
    }
}
