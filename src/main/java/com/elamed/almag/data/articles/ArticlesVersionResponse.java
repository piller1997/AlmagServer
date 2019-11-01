package com.elamed.almag.data.articles;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Response articles.
 */
public class ArticlesVersionResponse {
    @SerializedName("stat")
    private String stat;
    @SerializedName("articles")
    private List<ArticleVersion> articles;

    private ArticlesVersionResponse() {}

    /**
     * Creates new {@link ArticlesVersionResponse}'s builder.
     *
     * @return {@link ArticlesVersionResponse}'s builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new ArticlesVersionResponse().new Builder();
    }

    /**
     * {@link ArticlesVersionResponse}'s builder.
     */
    public class Builder {
        private Builder() {}

        /**
         * Sets stat of response.
         *
         * @param stat Stat of response.
         * @return This builder.
         */
        @Nonnull
        public Builder setStat(@Nonnull String stat) {
            ArticlesVersionResponse.this.stat = Objects.requireNonNull(stat);
            return this;
        }

        /**
         * Sets articles of response.
         *
         * @param articles articles of response.
         * @return This builder.
         */
        @Nonnull
        public Builder setArticles(@Nonnull List<ArticleVersion> articles) {
            ArticlesVersionResponse.this.articles = Objects.requireNonNull(articles);
            return this;
        }

        /**
         * Returns response.
         *
         * @return Response.
         */
        @Nonnull
        public ArticlesVersionResponse build() {
            return ArticlesVersionResponse.this;
        }
    }
}
