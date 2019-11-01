package com.elamed.almag.db;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Nonnull;

import com.elamed.almag.data.articles.Article;
import com.elamed.almag.data.articles.ArticleVersion;
import com.elamed.almag.data.plans.Plan;
import com.elamed.almag.data.plans.PlanDetalization;

/**
 * DAO for working with articles are data storage.
 */
public interface AnalyzableDao {
    /**
     * Gets list of articles with versions.
     *
     * @return last version of articles.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    List<ArticleVersion> getArticles() throws SQLException;

    /**
     * Gets full info about article.
     *
     * @param id Id of article.
     * @return article.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    Article getArticle(int id) throws SQLException;

    /**
     * Add new rate of treating.
     *
     * @param idPlan Detalize plan's id.
     * @param yearBirth User's year birth.
     * @param rateBefore Rate before treating.
     * @param rateAfter Rate after treating.
     * @param gender User's gender.
     * @param diseaseName User's disease
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    void addRates(int idPlan, int yearBirth, int rateBefore, int rateAfter, @Nonnull String gender, @Nonnull String diseaseName)
            throws SQLException;

    /**
     * Gets all plans from data storage.
     *
     * @return All plans with versions.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    List<Plan> getPlans() throws SQLException;

    /**
     * Gets detalization's list by plan's id.
     *
     * @param planId Plan's id.
     * @return Detalization's list.
     * @throws SQLException SQL exception throws when something's wrong in DB.
     */
    List<PlanDetalization> getDetalization(int planId) throws SQLException;
}
