package com.elamed.almag.data.articles;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Article with version.
 */
public class ArticleVersion {
    @SerializedName("id")
    private int id;
    @SerializedName("version")
    private int version;

    private ArticleVersion() {}

    /**
     * Creates new Article's builder.
     *
     * @return Article's builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new ArticleVersion().new Builder();
    }

    /**
     * ArticleVersion's builder.
     */
    public class Builder {
        private Builder() {}

        /**
         * Sets id of article.
         *
         * @param id Id of article.
         * @return This builder.
         */
        @Nonnull
        public Builder setId(int id) {
            ArticleVersion.this.id = id;
            return this;
        }

        /**
         * Sets version of article.
         *
         * @param version Version of article.
         * @return This builder.
         */
        @Nonnull
        public Builder setVersion(int version) {
            ArticleVersion.this.version = version;
            return this;
        }

        /**
         * Returns article.
         *
         * @return Article.
         */
        @Nonnull
        public ArticleVersion build() {
            return ArticleVersion.this;
        }
    }
}
