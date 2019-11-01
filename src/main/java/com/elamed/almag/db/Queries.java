package com.elamed.almag.db;

import java.util.Objects;

import javax.annotation.Nonnull;

/**
 * Queries for database.
 */
public enum Queries {
    GET_ARTICLES("SELECT id, version FROM articles"), GET_ARTICLE(
            "SELECT id, name_article, content_article, prefix, video_link, version FROM articles WHERE id=?"),
    ADD_RATE(
            "INSERT INTO rates(plan, year_birth, rateBefore, rateAfter, gender, diseaseName) VALUES (?, ?, ?, ?, ?, ?)"),
    GET_PLANS("SELECT id, age_min, age_max, version FROM plan"),
    GET_DETALIZATION("SELECT id, mode, duration, day, skip FROM detalized_plan WHERE plan=?");
    private final String value;

    /**
     * Creates instance.
     *
     * @param value query.
     */
    Queries(@Nonnull String value) {
        this.value = Objects.requireNonNull(value);
    }

    /**
     * Gets value of instance.
     *
     * @return query for database.
     */
    @Nonnull
    public String getValue() {
        return value;
    }
}
