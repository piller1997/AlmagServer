package com.elamed.almag.data.plans;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Plan's description.
 */
public class Plan {
    @SerializedName("id")
    private int id;
    @SerializedName("ageMin")
    private int ageMin;
    @SerializedName("ageMax")
    private int ageMax;
    @SerializedName("version")
    private int version;

    private Plan() {}

    /**
     * Creates new Builder for building Plan.
     *
     * @return Builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new Plan().new Builder();
    }

    /**
     * Builder for building Plan.
     */
    public class Builder {
        private Builder() {}

        /**
         * Sets id to plan.
         *
         * @param id Plan's id.
         * @return This builder.
         */
        @Nonnull
        public Builder setId(int id) {
            Plan.this.id = id;
            return this;
        }

        /**
         * Sets ageMin to plan.
         *
         * @param ageMin Plan's ageMin.
         * @return This builder.
         */
        @Nonnull
        public Builder setAgeMin(int ageMin) {
            Plan.this.ageMin = ageMin;
            return this;
        }

        /**
         * Sets ageMax to plan.
         *
         * @param ageMax Plan's ageMax.
         * @return This builder.
         */
        @Nonnull
        public Builder setAgeMax(int ageMax) {
            Plan.this.ageMax = ageMax;
            return this;
        }

        /**
         * Sets version to plan.
         *
         * @param version Plan's version.
         * @return This builder.
         */
        @Nonnull
        public Builder setVersion(int version) {
            Plan.this.version = version;
            return this;
        }

        /**
         * Builds plan.
         *
         * @return Plan.
         */
        @Nonnull
        public Plan build() {
            return Plan.this;
        }
    }
}
