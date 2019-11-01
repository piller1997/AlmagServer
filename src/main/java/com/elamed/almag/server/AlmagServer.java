package com.elamed.almag.server;

import java.util.Objects;

import javax.annotation.Nonnull;

import com.elamed.almag.Properties;
import com.elamed.almag.data.articles.Article;
import com.elamed.almag.data.articles.ArticlesVersionResponse;
import com.elamed.almag.data.errors.Error;
import com.elamed.almag.data.errors.Message;
import com.elamed.almag.data.plans.PlanDetalizationsResponse;
import com.elamed.almag.data.plans.PlansResponse;
import com.elamed.almag.db.AnalyzableDao;
import com.elamed.almag.utils.JsonUtil;

import spark.Spark;

/**
 * Class, that's runs server in constructor.
 */
public class AlmagServer {
    private final String contentTypeJson = "application/json";
    private final String idParam = ":id";
    private final String fail = "fail";
    private final String ok = "ok";
    private final String genderName = "gender";
    private final Properties properties;
    private final AnalyzableDao dao;

    /**
     * Creates {@link AlmagServer} instance.
     *
     * @param properties Program's properties.
     * @param dao DAO for working with articles.
     */
    public AlmagServer(@Nonnull Properties properties, @Nonnull AnalyzableDao dao) {
        this.properties = Objects.requireNonNull(properties);
        this.dao = Objects.requireNonNull(dao);
    }

    /**
     * Configures and starts server.
     */
    public void start() {
        configureServer();
        articles();
        extract();
        addRates();
        detailedPlans();
        plans();
    }

    private void configureServer() {
        Spark.port(properties.getPortConnection());
        Spark.after((request, response) -> response.type(contentTypeJson));
    }

    private void plans() {
        Spark.get(URIes.PLANS.getValue(), (request, response) -> PlansResponse.newBuilder()
                .setStat(ok)
                .setPlans(dao.getPlans())
                .build(), JsonUtil.json());
        Spark.notFound(((request, response) -> notFound()));
    }

    private void detailedPlans() {
        Spark.get(URIes.DETAILED_PLANS.getValue(), (request, response) -> {
            final int planId;
            try {
                planId = Integer.parseInt(request.params(idParam));
            } catch (NumberFormatException e) {
                return numberFormatException(idParam);
            }
            return PlanDetalizationsResponse.newBuilder()
                    .setStat(ok)
                    .setDetalizations(dao.getDetalization(planId));
        }, JsonUtil.json());
    }

    private void addRates() {
        Spark.post(URIes.ADD_RATES.getValue(), "application/json", (request, response) -> {
            final int idPlan;
            final int yearBirth;
            final int rateBefore;
            final int rateAfter;
            final String gender = request.queryParams(genderName);
            final String idPlanString = "idPlan";
            final String yearBirthString = "yearBirth";
            final String rateBeforeString = "rateBefore";
            final String rateAfterString = "rateAfter";
            final String diseaseNameString = "diseaseName";
            final String diseaseName = request.queryParams(diseaseNameString);
            try {
                idPlan = Integer.parseInt(request.queryParams(idPlanString));
            } catch (NumberFormatException e) {
                return numberFormatException(idPlanString);
            }
            try {
                yearBirth = Integer.parseInt(request.queryParams(yearBirthString));
            } catch (NumberFormatException e) {
                return numberFormatException(yearBirthString);
            }
            try {
                rateBefore = Integer.parseInt(request.queryParams(rateBeforeString));
            } catch (NumberFormatException e) {
                return numberFormatException(rateBeforeString);
            }
            try {
                rateAfter = Integer.parseInt(request.queryParams(rateAfterString));
            } catch (NumberFormatException e) {
                return numberFormatException(rateAfterString);
            }
            if (!"".equals(gender) && !"".equals(diseaseName)) {
                dao.addRates(idPlan, yearBirth, rateBefore, rateAfter, gender, diseaseName);
                response.status(200);
                return "OK";
            } else {
                return numberFormatException(genderName);
            }
        }, JsonUtil.json());
    }

    private void extract() {
        Spark.get(URIes.ARTICLE.getValue(), (request, response) -> {
            final int id;
            try {
                id = Integer.parseInt(request.params(idParam));
            } catch (NumberFormatException e) {
                return numberFormatException(idParam);
            }
            final Article article = dao.getArticle(id);
            if (article != null) {
                return article;
            } else {
                return notFound();
            }
        }, JsonUtil.json());
    }

    private void articles() {
        Spark.get(URIes.ARTICLES.getValue(),
                (request, response) -> ArticlesVersionResponse.newBuilder()
                        .setArticles(dao.getArticles())
                        .setStat(ok)
                        .build(), JsonUtil.json());
    }

    @Nonnull
    private Error notFound() {
        final Message message =
                Message.newBuilder().setMessage("Object does not exist").setCode(100).build();
        return Error.newBuilder().setStat(fail).setMessage(message).build();
    }

    @Nonnull
    private Error numberFormatException(@Nonnull String field) {
        Objects.requireNonNull(field);
        final Message message =
                Message.newBuilder().setMessage(field + " data is illegal.").setCode(200).build();
        return Error.newBuilder().setStat(fail).setMessage(message).build();
    }
}
