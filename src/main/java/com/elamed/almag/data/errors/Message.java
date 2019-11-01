package com.elamed.almag.data.errors;

import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Message of {@link Error} error.
 */
public class Message {
    @SerializedName("msg")
    private String message;
    @SerializedName("code")
    private int code;

    private Message() { }

    /**
     * Creates new Message's builder.
     *
     * @return Message's builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new Message().new Builder();
    }

    /**
     * Message's builder for creating error.
     */
    public class Builder {
        private Builder() { }

        /**
         * Sets message for json answer.
         *
         * @param message message to answer.
         * @return this builder.
         */
        @Nonnull
        public Builder setMessage(String message) {
            Message.this.message = Objects.requireNonNull(message);
            return this;
        }

        /**
         * Sets code for json answer.
         *
         * @param code code of answer.
         * @return this builder.
         */
        @Nonnull
        public Builder setCode(int code) {
            Message.this.code = code;
            return this;
        }

        /**
         * Returns message.
         *
         * @return message.
         */
        @Nonnull
        public Message build() {
            return Message.this;
        }
    }
}
