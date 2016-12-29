package com.article.model;

import java.util.ArrayList;

import java.util.List;
import com.google.code.morphia.annotations.Entity;
import com.project.logger.LoggerConstants;
import com.project.sources.MorphiaObject;
import play.Logger;

@Entity
public class User extends BaseAbstractModel {

	String email_id;
	String username;
	String name;
	String password;
	String date_Of_Birth;
	String gender;
	String mobile_no;
	String country;
	String city;
	String postal_Zip_Code;
	ArrayList<String> list_article_Name;

	/**
	 * Instantiates a new place.
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate_Of_Birth() {
		return date_Of_Birth;
	}

	public void setDate_Of_Birth(String date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostal_Zip_Code() {
		return postal_Zip_Code;
	}

	public void setPostal_Zip_Code(String postal_Zip_Code) {
		this.postal_Zip_Code = postal_Zip_Code;
	}

	public ArrayList<String> getArticleName() {
		if(this.list_article_Name == null){ return new ArrayList<>(); }
		return this.list_article_Name;
	}

	public void setArticleName(String article_Name) {
		if (this.list_article_Name == null) {
			this.list_article_Name = new ArrayList<>();
			this.list_article_Name.add(article_Name);
		} else {
			boolean flag = true;
			for (int i = 0; i < this.list_article_Name.size(); i++) {
				if (this.list_article_Name.get(i) == article_Name) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				this.list_article_Name.add(article_Name);
			}

		}
	}

	/**
	 * 
	 * @param emailId
	 * @param firstName
	 * @param lastName
	 * @param isAdmin
	 * @param isBlocked
	 * @param password
	 */
	public User(String email_id, String username, String name, String password, String date_of_birth, String gender,
			String mobile_no, String country, String city, String postal_Zip_Code, String article_Name) {
		id = email_id;
		this.setEmail_id(email_id);

		this.setUserName(username);

		this.setName(name);

		this.setPassword(password);

		this.setDate_Of_Birth(date_of_birth);
		this.setGender(gender);
		this.setMobile_no(mobile_no);
		this.setCountry(country);
		this.setCity(city);
		this.setPostal_Zip_Code(postal_Zip_Code);
		this.setArticleName(article_Name);
	}

	public static ArrayList<String> getUserArticles(String userId) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		// TODO use input parameter check
		if (userId == null || userId.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}
		User userObj = MorphiaObject.getDatastore().get(User.class, userId);
		if (userObj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}
		Logger.of(LoggerConstants.PROJECT_LOGGER).info(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
		ArrayList<String> list_ArticleNameOfUser = userObj.list_article_Name;

		return list_ArticleNameOfUser;
	}

	public static List<User> getAllUsers() {
		List<User> userList = MorphiaObject.getDatastore().find(User.class).asList();
		return userList;
	}

	public ArrayList<Article> getAllPublishArticle() {
		List<Article> publishArticle = MorphiaObject.getDatastore().find(Article.class).asList();
		ArrayList<Article> publishArticles = new ArrayList<>(publishArticle);
		return publishArticles;
	}

	public static ArrayList<Article> getAllPublishArticleOfUser(String username) {
		ArrayList<String> listOfArticleName = getUserArticles(username);
		ArrayList<Article> listOfPublishArticle = new ArrayList<>();
		// Iterator<String> it_ListOfArticleName = listOfArticleName.iterator();
		// while(it_ListOfArticleName.hasNext()){
		//
		// Article articleObj = new Article();
		// articleObj = (Article)
		// articleObj.get(it_ListOfArticleName.next().toString());
		// listOfPublishArticle.add(articleObj);
		// }

		for (int i = 0; i < listOfArticleName.size(); i++) {
			Article articleObj = new Article();
			articleObj = (Article) articleObj.get(listOfArticleName.get(i));
			listOfPublishArticle.add(articleObj);
		}

		return listOfPublishArticle;
	}

	public static userProfile getUserProfile(String uid) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		if (uid == null || uid.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}
		User userObj = MorphiaObject.getDatastore().get(User.class, uid);
		if (userObj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		ArrayList<Article> articleList = new ArrayList<>();
		ArrayList<String> list_ids = userObj.getArticleName();
		// Iterator<String> it_List_ids=list_ids.iterator();
		// while(it_List_ids.hasNext()){
		// Article article = MorphiaObject.getDatastore().get(Article.class,
		// it_List_ids.next());
		// articleList.add(article);
		// }
		for (int i = 0; i < list_ids.size(); i++) {
			Article article = MorphiaObject.getDatastore().get(Article.class, list_ids.get(i));
			articleList.add(article);

		}

		userObj.getArticleName().clear();
		userProfile userProfile = new userProfile();
		userProfile.setArticles(articleList);
		userProfile.setUserObj(userObj);
		return userProfile;
	}

	public static boolean userValidation(String uid, String psw) {
		// get user
		User userObj = (User) new User().get(uid);
		// validate
		if (userObj.getPassword().equals(psw)) {
			return true;
		}
		return false;
	}
}
