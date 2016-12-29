package com.article.model;


import com.google.code.morphia.annotations.Id;
import com.project.logger.LoggerConstants;
import com.project.sources.MorphiaObject;
import com.project.utils.CommonUtils;

import play.Logger;

public abstract class BaseAbstractModel implements CRUDInterface, Cloneable {

	@Id
	String id;
	
	@Override
	public BaseAbstractModel get(String id) {

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.ID + id);

		// TODO use input parameter check
		if (id == null || id.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		BaseAbstractModel savedObj = MorphiaObject.getDatastore().get(this.getClass(), id);

		if (savedObj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		Logger.of(LoggerConstants.PROJECT_LOGGER).info(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.GET_DB_OBJECT);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);

		return savedObj;
	}

	/* (non-Javadoc)
	 * @see com.project.placeModel.IPersistanceObject#put(com.project.placeModel.Place)
	 */
	@Override
	public void put(BaseAbstractModel obj) {
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
	

		if (obj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return;
		}
		MorphiaObject.getDatastore().save(obj);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.SAVE_MESSAGE);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
	}

	/* (non-Javadoc)
	 * @see com.project.placeModel.IPersistanceObject#delete(java.lang.String)
	 */
	@Override
	/*
	 * Deletes the object in Database
	 * 
	 * @Params Id of the Object
	 * 
	 * @return deleted object
	 */
	public BaseAbstractModel delete(String Id) {

		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_ENTRY);
		Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.INPUT_PARAMS + LoggerConstants.LOGGER_SPACE
				+ LoggerConstants.LOGGER_COLON + LoggerConstants.LOGGER_SPACE + Id);

		if (Id == null || Id.isEmpty()) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);
			return null;
		}

		BaseAbstractModel savedObj = get(Id);

		if (savedObj == null) {
			Logger.of(LoggerConstants.PROJECT_LOGGER)
					.error(LoggerConstants.RETURN_OBJ + LoggerConstants.LOGGER_SPACE + null);
			Logger.of(LoggerConstants.PROJECT_LOGGER).debug(LoggerConstants.METHOD_EXIT);

			return null;
		}

		MorphiaObject.getDatastore().delete(this.getClass(), Id);

		Logger.info(LoggerConstants.DELETED);
		return savedObj;
	}

}
