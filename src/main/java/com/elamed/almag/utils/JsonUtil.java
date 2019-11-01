package com.elamed.almag.utils;

import javax.annotation.Nonnull;

import com.google.gson.Gson;

import spark.ResponseTransformer;

/**
 * JSON Util for Spark server.
 */
public class JsonUtil {
    private JsonUtil() {}

    /**
     * Converts object to JSON.
     *
     * @param object Convertible object.
     * @return Parsed JSON from object.
     */
    @Nonnull
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    /**
     * Gets {@link ResponseTransformer} to converting.
     *
     * @return {@link ResponseTransformer} to converting.
     */
    @Nonnull
    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
