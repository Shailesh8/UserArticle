package controllers;

import java.util.ArrayList;
import java.util.List;

import com.project.utils.CommonUtils;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import com.article.model.Article;
import com.article.model.Category;
import com.article.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.project.logger.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationController.
 */
public class ApplicationController extends Controller {

	/**
	 * Index.
	 *
	 * @return the result
	 */
	public static Result index() {
		return ok();
	}

	
	public static Result doLogout() {
		SessionController.clearSession();
		return ok();
	}

	public static Result login() {
		JsonNode loginJson = request().body().asJson();
		JsonNode jsonElement = loginJson.path(ControllerConstant.JSON_LOGIN_EMAIL);
		if (jsonElement == null) {
			return badRequest();
		}
		String userEmail = jsonElement.textValue();
		jsonElement = loginJson.path(ControllerConstant.JSON_LOGIN_PASSWORD);
		if (jsonElement == null) {
			return badRequest();
		}
		String userPassword = jsonElement.textValue();
		if (User.userValidation(userEmail, userPassword)) {
			SessionController.createSessionForUser(userEmail);
			return ok();
		} else {
			return badRequest();
		}
	}


	public static Result signup() {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		JsonNode signUpJson = request().body().asJson();
		User user = CommonUtils.getGason().fromJson(signUpJson.toString(), User.class);
		user.put(user);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		return ok();
	}

	// User can publish an article
	public static Result publishAnArticle(String uid) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		if (SessionController.isSessionNotExist()) {
			return badRequest();
		}
		JsonNode ArticleJSON = request().body().asJson();
		Article article = CommonUtils.getGason().fromJson(ArticleJSON.toString(), Article.class);
		article.addArticle(uid, article);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		return ok();
	}

	public static Result getUserArticles(String userID) {
		if (SessionController.isSessionNotExist()) {
			return badRequest();
		}
		ArrayList<Article> articleList = User.getAllPublishArticleOfUser(userID);
		String Articlesjson = CommonUtils.getGason().toJson(articleList);
		return ok(Articlesjson);
	}

	public static Result getCategoryArticles(String category) {
		if (SessionController.isSessionNotExist()) {
			return badRequest();
		}
		ArrayList<Article> listOfArticleName = Category.getArticlesByCategory(category);
		String Articlesjson = CommonUtils.getGason().toJson(listOfArticleName);
		return ok(Articlesjson);
	}

	public static Result getAllTheUsers() {
		if (SessionController.isSessionNotExist()) {
			return badRequest();
		}
		List<User> users = User.getAllUsers();
		String usersNamejson = CommonUtils.getGason().toJson(users);
		return ok(usersNamejson);
	}

	public static Result getModifyCategoryOfArticle(String newCategory, String articleID) {
		if (SessionController.isSessionNotExist()) {
			return badRequest();
		}
		Article.modifyTheCategoryOfArticle(newCategory, articleID);
		return ok();
	}

	

	
	public static Result userProfile(String uid) {
		if (SessionController.isSessionNotExist()) {
			return badRequest();
		}
		com.article.model.userProfile up = User.getUserProfile(uid);
		return ok(CommonUtils.getGason().toJson(up));
	}

	public static Result removeArticle(String id) {
		if (SessionController.isSessionNotExist()) {
			return badRequest();
		}
		Article.removeArticle(id);
		return ok();
	}
}
