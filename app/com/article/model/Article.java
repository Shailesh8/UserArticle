package com.article.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.google.code.morphia.annotations.Entity;
import com.project.logger.LoggerConstants;
import com.project.sources.MorphiaObject;

import play.Logger;

@Entity
public class Article extends BaseAbstractModel {

	private String article_name;

	private String publishArticle;

	private String category;

	public String getArticle_Category() {
		return category;
	}

	public void setArticle_Category(String article_Category) {
		this.category = article_Category;
	}

	public void setArticle(String publishArticle) {
		this.publishArticle = publishArticle;
	}

	public String getArticle() {
		if (publishArticle.isEmpty() || publishArticle == null) {
			publishArticle = "";
		}
		return publishArticle;
	}

	public void setArticle_Name(String article_name) {
		this.article_name = article_name;

	}

	public String getArticle_Name() {
		return article_name;
	}

	public Article() {

	}

	HashMap<String, String> map_articleNameToPublishArticle = new HashMap<>();

	public Article(String publishArticle, String article_name, String article_Category) {
		id = article_name;
		this.setArticle(publishArticle);
		this.setArticle_Name(article_name);
		this.setArticle_Category(article_Category);
	}

	public void addArticle(String userID, Article obj) {
		put(obj);
		User userObj = new User();
		userObj = (User) userObj.get(userID);
		Category categoryObj = MorphiaObject.getDatastore().get(Category.class, obj.category);

		if (categoryObj == null) {
			categoryObj = new Category(obj.category, obj.id);
		} else {
			if (!isExist(categoryObj.getArticle(), obj.id))
				categoryObj.setArticle(obj.id);

		}
		categoryObj.put(categoryObj);

		if(!isExist(userObj.getArticleName(), obj.id)){
			userObj.setArticleName(obj.id);
		}
		userObj.put(userObj);
		obj.put(obj);
	}

	public boolean isExist(ArrayList<String> list, String name) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static void modifyTheCategoryOfArticle(String newCategory, String articleID) {

		Article article = MorphiaObject.getDatastore().get(Article.class, articleID);
		String oldCategory = article.getArticle_Category();
		article.setArticle_Category(newCategory);
		article.put(article);

		Category categoryObj = MorphiaObject.getDatastore().get(Category.class, oldCategory);
		ArrayList<String> list_ArticleName = categoryObj.getArticle();

		for (int i = 0; i < list_ArticleName.size(); i++) {
			if (list_ArticleName.get(i) == articleID) {
				list_ArticleName.remove(i);
				break;
			}
		}
		categoryObj.setArticle(list_ArticleName);
		categoryObj.put(categoryObj);

		Category categoryObjNew = MorphiaObject.getDatastore().get(Category.class, newCategory);

		if (categoryObjNew == null) {
			categoryObjNew = new Category(newCategory, articleID);
		} else {
			categoryObjNew.setArticle(articleID);
		}
		categoryObjNew.put(categoryObjNew);
	}

	public static void removeArticle(String articleName) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.INPUT_PARAMS + LoggerConstants.LOGGER_SPACE
				+ LoggerConstants.LOGGER_COLON + LoggerConstants.LOGGER_SPACE + articleName);

		if (articleName == null || articleName.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return;
		}

		Article article = MorphiaObject.getDatastore().get(Article.class, articleName);

		if (article == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return;
		}

		String categoryName = article.category;

		MorphiaObject.getDatastore().delete(Article.class, articleName);

		Category categoryObj = MorphiaObject.getDatastore().get(Category.class, categoryName);

		ArrayList<String> list_ArticleName = categoryObj.getArticle();
		if (list_ArticleName.size() > 1) {
			for (int i = 0; i < list_ArticleName.size(); i++) {
				if (list_ArticleName.get(i) == articleName) {
					list_ArticleName.remove(i);
					break;
				}
			}
			categoryObj.setArticle(list_ArticleName);
			categoryObj.put(categoryObj);
		} else {
			if (list_ArticleName.size() == 1) {
				MorphiaObject.getDatastore().delete(Category.class, categoryName);
			}
		}
		Logger.info(LoggerConstants.DELETED);
	}

}
