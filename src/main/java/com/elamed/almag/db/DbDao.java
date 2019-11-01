package com.elamed.almag.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.elamed.almag.Properties;
import com.elamed.almag.data.articles.Article;
import com.elamed.almag.data.articles.ArticleVersion;
import com.elamed.almag.data.plans.Plan;
import com.elamed.almag.data.plans.PlanDetalization;

/**
 * DB for working with articles.
 */
public class DbDao extends AbstractDbConnector implements AnalyzableDao {
    /**
     * Creates {@link DbDao} instance.
     *
     * @param properties Program's properties.
     */
    public DbDao(@Nonnull Properties properties) {
        super(properties);
    }

    /**
     * Gets list of articles with versions.
     *
     * @return last version of articles.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    @Nonnull
    @Override
    public List<ArticleVersion> getArticles() throws SQLException {
        return connectAndExecute(connection -> {
            final List<ArticleVersion> articles = new ArrayList<>();
            final PreparedStatement statement =
                    connection.prepareStatement(Queries.GET_ARTICLES.getValue());
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final int id = resultSet.getInt(1);
                final int version = resultSet.getInt(2);
                articles.add(ArticleVersion.newBuilder().setId(id).setVersion(version).build());
            }
            return articles;
        });
    }

    /**
     * Gets full info about article.
     *
     * @param id Id of article.
     * @return article.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    @Nonnull
    @Override
    public Article getArticle(int id) throws SQLException {
        return connectAndExecute(connection -> {
            final Article article;
            final PreparedStatement statement =
                    connection.prepareStatement(Queries.GET_ARTICLE.getValue());
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                final String nameArticle = resultSet.getString(2);
                final String contentArticle = resultSet.getString(3);
                final String prefix = resultSet.getString(4);
                final String videolink = resultSet.getString(5);
                final int version = resultSet.getInt(6);
                article = Article.newBuilder()
                        .setContentArticle(contentArticle)
                        .setNameArticle(nameArticle)
                        .setId(id)
                        .setPref(prefix)
                        .setVersion(version)
                        .setVideoLink(videolink)
                        .setStat("ok")
                        .build();
            } else {
                article = null;
            }
            return article;
        });
    }

    /**
     * Adds new rate of treating.
     *
     * @param idPlan Detalize plan's id.
     * @param yearBirth User's year birth.
     * @param rateBefore Rate before treating.
     * @param rateAfter Rate after treating.
     * @param gender User's gender.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    @Override
    public void addRates(int idPlan, int yearBirth, int rateBefore, int rateAfter,
            @Nonnull String gender, @Nonnull String diseaseName) throws SQLException {
        connectAndExecute(connection -> {
            final PreparedStatement statement =
                    connection.prepareStatement(Queries.ADD_RATE.getValue());
            statement.setInt(1, idPlan);
            statement.setInt(2, yearBirth);
            statement.setInt(3, rateBefore);
            statement.setInt(4, rateAfter);
            statement.setString(5, gender);
            statement.setString(6, diseaseName);
            statement.execute();
            return null;
        });
    }

    /**
     * Gets all plans from data storage.
     *
     * @return All plans with versions.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    @Nonnull
    @Override
    public List<Plan> getPlans() throws SQLException {
        return connectAndExecute(connection -> {
            final List<Plan> plans = new ArrayList<>();
            final PreparedStatement statement =
                    connection.prepareStatement(Queries.GET_PLANS.getValue());
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                plans.add(Plan.newBuilder()
                        .setId(resultSet.getInt(1))
                        .setAgeMin(resultSet.getInt(2))
                        .setAgeMax(resultSet.getInt(3))
                        .setVersion(resultSet.getInt(4))
                        .build());
            }
            return plans;
        });
    }

    /**
     * Gets detalization's list by plan's id.
     *
     * @param planId Plan's id.
     * @return Detalization's list.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    @Nonnull
    @Override
    public List<PlanDetalization> getDetalization(int planId) throws SQLException {
        return connectAndExecute(connection -> {
            final List<PlanDetalization> planDetalizations = new ArrayList<>();
            final PreparedStatement statement =
                    connection.prepareStatement(Queries.GET_DETALIZATION.getValue());
            statement.setInt(1, planId);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                planDetalizations.add(PlanDetalization.newBuilder()
                        .setId(resultSet.getInt(1))
                        .setMode(resultSet.getInt(2))
                        .setDuration(resultSet.getInt(3))
                        .setDay(resultSet.getInt(4))
                        .setSkip(resultSet.getBoolean(5))
                        .build());
            }
            return planDetalizations;
        });
    }
}
