package com.lxy.common.constants;

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

/**
 * FXCS File Exception
 * <p>
 * Module:   FXCS CLEARING
 *
 * @author   xiaoxia
 * @version  
 * @see      FileException
 */
public class FileException extends Exception {

	private static final long serialVersionUID = 8985447332819605768L;

	/**
	 * constructor
	 */
	public FileException() {
		super();
	}

	/**
	 * constructor
	 * 
	 * @param message
	 *            message
	 * @param cause
	 *            cause
	 */
	public FileException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * constructor
	 * 
	 * @param message
	 *            message
	 */
	public FileException(String message) {
		super(message);
	}

	/**
	 * constructor
	 * 
	 * @param cause
	 *            cause
	 */
	public FileException(Throwable cause) {
		super(cause);
	}

}
