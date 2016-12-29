package com.article.model;


public interface CRUDInterface {

	/**
	 * Gets the.
	 *
	 * @param Id the id
	 * @return the place
	 */
	public BaseAbstractModel get(String username);
	
	/**
	 * Put.
	 *
	 * @param obj the obj
	 */
	public void put(BaseAbstractModel obj);
	
	/**
	 * Delete.
	 *
	 * @param Id the id
	 * @return the place
	 */
	public  BaseAbstractModel delete(String Id);

}
