/**  ©2012, NCS (China) CO.LTD.All rights reserved.
 *
 *   Foreign Exchange Clearing System - version 1.2.0
 *
 *   This software is the property of NCS and its licensors and is protected by copyright. 
 *   Any reproduction in whole or in part is strictly prohibited.
 *  
 *   you can use the production compliance with the License. 
 *
 *   You can obtain a copy of the License at
 *
 *   http://www.ncs.com.sg
 *
 *   Unless required by applicable law or agreed to in writing.
 *   Source coding and software can be distributed  by the authorization of NCS,only.
 *   All other related product, document and logos are trademarks or registered trademarks of NCS.
 */
/*
 * Change Revision
 * ---------------
 * Date     		Author    			Remarks
 * 2012-2-4   		xiaoxia  		    initial files
 */
package com.lxy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * System Property
 * <p>
 * Module:   FXCS CLEARING
 *
 * @author   xiaoxia
 * @version  
 * @see      SystemProperty
 */
public class SystemProperty {
	private static Log log = LogFactory.getLog(SystemProperty.class);

	private static String defaultFileName = "ncs.properties";
	private static PropertyResourceBundle property;
	
//	private static Properties property;

	static {
		try {
			loadProperty();
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	/** Constructor. */
	private SystemProperty() {
	}

	/**
	 * Retrieves the value of the key.
	 * 
	 * @param key
	 *            Key identifier for the value to be retrieved.
	 */
	public static String getProperty(String key) throws Exception {
		if (property == null) {
			loadProperty();
		}
		String result = getString(key);
		if (result == null){
			throw new MissingResourceException("Cannot find property value for ", "", key);
		}
		return result.trim();
	}

	/**
	 * Convenience method to save handling MissingResourceException and checking both property object
	 * 
	 * @param key
	 *            Key to identify the property
	 * @return property value for the key.
	 */
	private static String getString(String key) {
		String result;
		try {
			result = property.getString(key);
		} catch (MissingResourceException e) {
			result = null;
		}

		return result;
	}

	/**
	 * load property
	 * @throws IOException e
	 * @throws FileNotFoundException e
	 */
	private static void loadProperty() throws Exception {
		try {
			loadProperty(defaultFileName);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * load property
	 * @param propFileName String
	 * @throws Exception e
	 * @throws IOException e
	 */
	private static void loadProperty(String propFileName) throws Exception, IOException {
		InputStream fis;
		String path = "/"+propFileName;

		try {
			fis = SystemProperty.class.getResourceAsStream(path);
		} catch (Exception fe1) {
			log.error("Searching system configuration file failed at " + path);
			throw fe1;
		}

		property = new PropertyResourceBundle(fis);
		log.debug("Config file - " + propFileName + " has been loaded");
	}

	/**
	 * inital property
	 * @param propFileName String
	 * @throws Exception e
	 */
	public static void init(String propFileName) throws Exception{
		if(!defaultFileName.equals(propFileName)){
			loadProperty(propFileName);
		}
	}
	
}
