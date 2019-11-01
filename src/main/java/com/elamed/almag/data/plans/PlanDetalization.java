package com.elamed.almag.data.plans;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Detalization plan's description.
 */
public class PlanDetalization {
    @SerializedName("id")
    private int id;
    @SerializedName("mode")
    private int mode;
    @SerializedName("duration")
    private int duration;
    @SerializedName("day")
    private int day;
    @SerializedName("skip")
    private boolean skip;

    private PlanDetalization() {}

    /**
     * Creates new Builder for building PlanDetalization.
     *
     * @return Builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new PlanDetalization().new Builder();
    }

    /**
     * Builder for building Plan.
     */
    public class Builder {
        private Builder() {}

        /**
         * Sets id to detalization.
         *
         * @param id PlanDetalization's id.
         * @return This builder.
         */
        @Nonnull
        public Builder setId(int id) {
            PlanDetalization.this.id = id;
            return this;
        }

        /**
         * Sets mode to detalization.
         *
         * @param mode PlanDetalization's mode.
         * @return This builder.
         */
        @Nonnull
        public Builder setMode(int mode) {
            PlanDetalization.this.mode = mode;
            return this;
        }

        /**
         * Sets duration to detalization.
         *
         * @param duration PlanDetalization's duration.
         * @return This builder.
         */
        @Nonnull
        public Builder setDuration(int duration) {
            PlanDetalization.this.duration = duration;
            return this;
        }

        /**
         * Sets day to detalization.
         *
         * @param day PlanDetalization's day.
         * @return This builder.
         */
        @Nonnull
        public Builder setDay(int day) {
            PlanDetalization.this.day = day;
            return this;
        }

        /**
         * Sets skip to detalization.
         *
         * @param skip PlanDetalization's skip.
         * @return This builder.
         */
        @Nonnull
        public Builder setSkip(boolean skip) {
            PlanDetalization.this.skip = skip;
            return this;
        }

        /**
         * Builds plan.
         *
         * @return Plan.
         */
        @Nonnull
        public PlanDetalization build() {
            return PlanDetalization.this;
        }
    }
}
