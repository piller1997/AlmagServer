package com.elamed.almag.server;

import java.util.Objects;

import javax.annotation.Nonnull;

/**
 * Enum of URI for server's queries.
 */
public enum URIes {
    ARTICLES("/articles/"), ARTICLE("/articles/:id/"), ADD_RATES("/rates/"),
    PLANS("/plans/"), DETAILED_PLANS("/plans/:id/detailed/");
    private final String value;

    /**
     * Creates {@link URIes} instance.
     *
     * @param value URI string.
     */
    @Nonnull
    URIes(@Nonnull String value) {
        this.value = Objects.requireNonNull(value);
    }

    /**
     * Gets URI string.
     *
     * @return URI string.
     */
    @Nonnull
    public String getValue() {
        return value;
    }
}
