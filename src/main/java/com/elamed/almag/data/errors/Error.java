package com.elamed.almag.data.errors;

import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Response to client on wrong query.
 */
public class Error {
    @SerializedName("stat")
    private String status;
    @SerializedName("err")
    private Message message;

    private Error() {}

    /**
     * Creates new Error builder.
     *
     * @return Error builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new Error().new Builder();
    }

    /**
     * Error builder for creating error.
     */
    public class Builder {
        private Builder() { }

        /**
         * Sets stat for json answer.
         *
         * @param stat message to answer.
         * @return this builder.
         */
        @Nonnull
        public Builder setStat(@Nonnull String stat) {
            Error.this.status = Objects.requireNonNull(stat);
            return this;
        }

        /**
         * Sets message for json answer.
         *
         * @param message message to answer.
         * @return this builder.
         */
        @Nonnull
        public Builder setMessage(@Nonnull Message message) {
            Error.this.message = Objects.requireNonNull(message);
            return this;
        }

        /**
         * Returns error.
         *
         * @return error.
         */
        @Nonnull
        public Error build() {
            return Error.this;
        }
    }
}
