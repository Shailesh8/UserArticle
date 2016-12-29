package com.article.model;

import java.util.ArrayList;

import com.google.code.morphia.annotations.Entity;
import com.project.logger.LoggerConstants;
import com.project.sources.MorphiaObject;

import play.Logger;

@Entity
public class Category extends BaseAbstractModel {

	private String category;

	private ArrayList<String> article_List;

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setArticle(String article_name) {
		if (this.article_List == null) {
			this.article_List = new ArrayList<>();
		}
		this.article_List.add(article_name);
	}
    public void setArticle(ArrayList<String> article_list){
     this.article_List=article_list; 	
    }
	
	public ArrayList<String> getArticle() {
		return article_List;
	}

	public Category(){
		
	}
	public Category(String category, String article_name) {
		// TODO Auto-generated constructor stub
		id=category;
		this.setCategory(category);
		this.setArticle(article_name);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.project.placeModel.IPersistanceObject#get(java.lang.String)
	 */

	public static ArrayList<String> getListOfArticleNameByCategory(String category) {

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.ID + category);

		// TODO use input parameter check
		if (category == null || category.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		Category catObje = MorphiaObject.getDatastore().get(Category.class, category);

		if (catObje == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		Logger.of(LoggerConstants.PROJECT_LOGGER).info(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);

		ArrayList<String> list_ArticleNamebyCategory = catObje.article_List;

		return list_ArticleNamebyCategory;
	}

	/*
	 * Get all the articles belonging to a category
	 */

	public static ArrayList<Article> getArticlesByCategory(String category) {
		ArrayList<String> list_ArticleName = getListOfArticleNameByCategory(category);

		ArrayList<Article> listOfPublishArticle = new ArrayList<>();
		for (int i = 0; i < list_ArticleName.size(); i++) {
			Article articleObj = new Article();
			articleObj = (Article) articleObj.get(list_ArticleName.get(i));
			listOfPublishArticle.add(articleObj);
		}
		return listOfPublishArticle;
	}
	
	
	
	
	/*
	 * Modify the category of a particular article
	 */

	public void modifyCategoryOfArticle(String temp) {

	}

}
