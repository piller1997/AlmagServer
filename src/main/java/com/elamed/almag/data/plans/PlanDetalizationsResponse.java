package com.elamed.almag.data.plans;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Response to client, that's contain list of plan's detalizations.
 */
public class PlanDetalizationsResponse {
    @SerializedName("stat")
    private String stat;
    @SerializedName("detalizations")
    private List<PlanDetalization> planDetalizations;

    private PlanDetalizationsResponse() {}

    /**
     * Creates new Builder.
     *
     * @return Builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new PlanDetalizationsResponse().new Builder();
    }

    /**
     * Builder for building PlanDetalizationsResponse.
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
            PlanDetalizationsResponse.this.stat = Objects.requireNonNull(stat);
            return this;
        }

        /**
         * Sets planDetalizations to detalization.
         *
         * @param planDetalizations PlanDetalizations.
         * @return This builder.
         */
        @Nonnull
        public Builder setDetalizations(@Nonnull List<PlanDetalization> planDetalizations) {
            PlanDetalizationsResponse.this.planDetalizations = Objects.requireNonNull(planDetalizations);
            return this;
        }

        /**
         * Builds PlanDetalizationsResponse.
         *
         * @return PlanDetalizationsResponse.
         */
        @Nonnull
        public PlanDetalizationsResponse build() {
            return PlanDetalizationsResponse.this;
        }
    }
}
