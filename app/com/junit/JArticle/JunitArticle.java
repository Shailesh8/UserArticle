package com.article.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.project.sources.MongoDB;
import com.project.utils.CommonUtils;

public class JunitArticle {

	public static final String emailID = "test@gmail.com";
	public static final String uname = "testUser";
	public static final String psw = "123";
	public static final String dob = "19-10-1989";
	public static final String gneder = "Male";
	public static final String mobNo = "9428639443";
	public static final String country = "India";
	public static final String city = "Hyderabad";
	public static final String code = "500081";
	public static final String name = "article002";
	public static final String publishArticle = "testing article feature";
	public static final String article_name = "testArticle0002";
	public static final String article_Category = "Hist";
    public static final String new_Article_Category="Science";
	@Test
	public void addArticleTest() throws IOException {
		// make user and article data
		db();
		User userObj = getTestUser();
		userObj.put(userObj);
		Article artObj = getArticle();
		new Article().addArticle(userObj.id, artObj);
		Article artObjExp = (Article) artObj.get(artObj.id);
		assertEquals(artObj.id, artObjExp.id);
	}

	User getTestUser() {
		User userObj = new User(emailID, uname, uname, psw, dob, gneder, mobNo, country, city, code, name);
		return userObj;
	}

	Article getArticle() {
		Article artObj = new Article(publishArticle, article_name, article_Category);
		return artObj;
	}

	void db() throws IOException{
		CommonUtils.loadConfigProperties();
		MongoDB.connectToDB();
	}
    public String getNewCategory(){
    	return new_Article_Category; 
    }
    
	@Test 
    public void modifyTheCategoryOfArticleTest() throws IOException{
      	db();
      	User userObj = getTestUser();
		userObj.put(userObj);       	
		Article artObj = getArticle();
		new Article().addArticle(userObj.id, artObj);
        new Article().modifyTheCategoryOfArticle(getNewCategory(),artObj.getArticle_Name() );             
        Article artObjExp = (Article) artObj.get(artObj.id);
        assertEquals(getNewCategory(), artObjExp.getArticle_Category());
	}
	
	

}
