package com.lxy.util;

import java.sql.*;


/**
 * This class provides a service to log messages to the database
 * as well as write it to a text file.
 * A service who would like to use this class needs only to
 * instantiate this class once by calling MessageHandler.getMessageHandler()
 * and then subsequently call notifyMessage() to log a message.
 * <p>
 * Module:   Message Handler
 *
 * @author   Preethi
 * @version  September 2000
 */

/*
 * Change Revision
 * ---------------
 * Date     Author    Remarks
 * -        -         -
 */

public class MessageHandler {
  static MessageHandler messageHandler;
  private static final String SEPARATOR = ";";
 
  /** Gets the message handler object. */
  public static MessageHandler getMessageHandler() {
    if (messageHandler == null) {
      messageHandler = new MessageHandler();
    }
    return (messageHandler);
  }
  
  public void notifyMessage(Exception e, String className, String methodName, String id){
	  addMessage(null, null, e.getMessage(), className, methodName, id);
  }
  
  public void notifyMessage(Long entityId, String entityType, Exception e, String className, String methodName, String id){
	  addMessage(entityId, entityType, e.getMessage(), className, methodName, id);
  }
  
  public void notifyMessage(Long entityId, String entityType, String msgDetail, String className, String methodName, String id){
	  addMessage(entityId, entityType, msgDetail, className, methodName, id);
  }

  public void notifyMessage(String msgDetail, String className, String methodName, String id){
	  addMessage(null, null, msgDetail, className, methodName, id);
  }
  
  synchronized void addMessage(Long entityId, String entityType, String msgDetail, String className, String methodName, String id) {
		Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
		Debugger.setTraceLevel(Debugger.LEVEL_DEBUGGING);
		Debugger.setFileLog(true);
        Debugger.setSystemOut(true);
        
		Debugger.println(Debugger.LEVEL_INFO, "NotifyMessage() started at" + timestamp);
		StringBuffer msgBuf = new StringBuffer();

		msgBuf.append(id);
		msgBuf.append(SEPARATOR);
		msgBuf.append(entityId);
		msgBuf.append(SEPARATOR);
		msgBuf.append(entityType);
		msgBuf.append(SEPARATOR);
		msgBuf.append(msgDetail);
		msgBuf.append(SEPARATOR);
		msgBuf.append(className);
		msgBuf.append(SEPARATOR);
		msgBuf.append(methodName);
		msgBuf.append(SEPARATOR);
		Debugger.println(msgBuf.toString());

		Debugger.println(Debugger.LEVEL_INFO, "NotifyMessage() ended at" + timestamp);
  }
}
