package com.elamed.almag;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Nonnull;

/**
 * Getter property from file.
 */

public final class Properties {
    private static final String MESSAGE_ABOUT_ERROR =
            "Property %s is absent in configuration file %s!";
    private final String propertyFile;
    private final Map<String, String> propertiesMap;

    /**
     * Creates {@link Properties} instance.
     *
     * @param propertyFile path to property file
     * @throws IOException properties file failed exception.
     */
    public Properties(@Nonnull final String propertyFile) throws IOException {
        this.propertyFile = Objects.requireNonNull(propertyFile);
        final Map<String, String> propertiesMap = new HashMap<>();
        try (FileInputStream propertyFIS = new FileInputStream(this.propertyFile)) {
            final java.util.Properties properties = new java.util.Properties();
            properties.load(propertyFIS);
            final Set<String> set = properties.stringPropertyNames();
            for (String property : set) {
                propertiesMap.put(property, properties.getProperty(property));
            }
        }
        this.propertiesMap = Collections.unmodifiableMap(propertiesMap);
    }

    /**
     * Gets port for connection to site.
     *
     * @return port.
     * @throws IllegalArgumentException Throws, when port connection is illegal.
     */
    public int getPortConnection() throws IllegalArgumentException {
        final String fieldName = "port";
        final String port = propertiesMap.get(fieldName);
        final int result;
        try {
            result = Integer.parseInt(Objects.requireNonNull(port,
                    () -> String.format(MESSAGE_ABOUT_ERROR, fieldName, propertyFile)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Specified port is not correct!");
        }

        return result;
    }

    /**
     * Gets url to connecting to database.
     *
     * @return url.
     */
    @Nonnull
    public String getUrlDatabase() {
        final String fieldName = "urlDatabase";
        return Objects.requireNonNull(propertiesMap.get(fieldName),
                () -> String.format(MESSAGE_ABOUT_ERROR, fieldName, propertyFile));
    }
}
