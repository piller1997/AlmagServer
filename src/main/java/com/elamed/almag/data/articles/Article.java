package com.elamed.almag.data.articles;

import java.util.Objects;

import javax.annotation.Nonnull;

import com.google.gson.annotations.SerializedName;

/**
 * Full info about article.
 */
public class Article {
    @SerializedName("stat")
    private String stat;
    @SerializedName("id")
    private int id;
    @SerializedName("name_article")
    private String nameArticle;
    @SerializedName("content_article")
    private String contentArticle;
    @SerializedName("pref")
    private String pref;
    @SerializedName("video_link")
    private String videoLink;
    @SerializedName("version")
    private int version;

    private Article() {}

    /**
     * Creates new Article's builder.
     *
     * @return Article's builder.
     */
    @Nonnull
    public static Builder newBuilder() {
        return new Article().new Builder();
    }

    /**
     * Article's builder.
     */
    public class Builder {
        private Builder() {}

        /**
         * Sets stat of article.
         *
         * @param stat Stat of response.
         * @return This builder.
         */
        @Nonnull
        public Builder setStat(@Nonnull String stat) {
            Article.this.stat = Objects.requireNonNull(stat);
            return this;
        }

        /**
         * Sets id of article.
         *
         * @param id Id of article.
         * @return This builder.
         */
        @Nonnull
        public Builder setId(int id) {
            Article.this.id = id;
            return this;
        }

        /**
         * Sets nameArticle of article.
         *
         * @param nameArticle NameArticle of article.
         * @return This builder.
         */
        @Nonnull
        public Builder setNameArticle(@Nonnull String nameArticle) {
            Article.this.nameArticle = Objects.requireNonNull(nameArticle);
            return this;
        }

        /**
         * Sets contentArticle of article.
         *
         * @param contentArticle ContentArticle of article.
         * @return This builder.
         */
        @Nonnull
        public Builder setContentArticle(@Nonnull String contentArticle) {
            Article.this.contentArticle = Objects.requireNonNull(contentArticle);
            return this;
        }

        /**
         * Sets pref of article.
         *
         * @param pref Pref of article.
         * @return This builder.
         */
        @Nonnull
        public Builder setPref(@Nonnull String pref) {
            Article.this.pref = Objects.requireNonNull(pref);
            return this;
        }

        /**
         * Sets videoLink of article.
         *
         * @param videoLink VideoLink of article.
         * @return This builder.
         */
        @Nonnull
        public Builder setVideoLink(@Nonnull String videoLink) {
            Article.this.videoLink = Objects.requireNonNull(videoLink);
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
            Article.this.version = version;
            return this;
        }

        /**
         * Returns article.
         *
         * @return Article.
         */
        @Nonnull
        public Article build() {
            return Article.this;
        }
    }
}
