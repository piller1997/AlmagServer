package com.elamed.almag.data.plans;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * List plans description.
 */
public class PlansResponse {
    @SerializedName("stat")
    private String stat;
    @SerializedName("plans")
    private List<Plan> plans;

    private PlansResponse() {}

    /**
     * Creates new Builder for building Plan.
     *
     * @return Builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new PlansResponse().new Builder();
    }

    /**
     * Builder for building Plan.
     */
    public class Builder {
        private Builder() {}

        /**
         * Sets stat to detalization.
         *
         * @param stat PlanDetalization's stat.
         * @return This builder.
         */
        @Nonnull
        public Builder setStat(@Nonnull String stat) {
            PlansResponse.this.stat = Objects.requireNonNull(stat);
            return this;
        }

        /**
         * Sets plans.
         *
         * @param plans Plans.
         * @return This builder.
         */
        @Nonnull
        public Builder setPlans(@Nonnull List<Plan> plans) {
            PlansResponse.this.plans = Objects.requireNonNull(plans);
            return this;
        }

        /**
         * Builds plan.
         *
         * @return Plan.
         */
        @Nonnull
        public PlansResponse build() {
            return PlansResponse.this;
        }
    }
}
