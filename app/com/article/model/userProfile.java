package com.article.model;

import java.util.ArrayList;

public class userProfile {

	User userObj;
	ArrayList<Article> articles;
	
	public User getUserObj() {
		return userObj;
	}
	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	public ArrayList<Article> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
}
