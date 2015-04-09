package com.lxy.log;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Wu Jie
 *
 */
public class LogContext {
	private static ThreadLocal<LogContext> currentContext = new ThreadLocal<LogContext>();
	
    public static LogContext getCurrentContext(){
    	if( currentContext.get()==null ) {
    		currentContext.set( new LogContext() ); 
    	}
    	return currentContext.get();
    }

    public static boolean isExistCurrentContext(){
    	return currentContext.get()!=null;
    }
    
    public static void removeCurrrentContext(){
    	currentContext.remove();
    }
	
    /**
     * create a new BusinessLog object and add it to current context
     * @return created BusinessLog object
     */
    public static BusinessLog addLogToCurrrentContext(){
    	BusinessLog log = new BusinessLog();
    	getCurrentContext().addLog(log);
    	return log;
    }
    
	private LogContext(){}
	
	private List<BusinessLog> logs = new ArrayList<BusinessLog>();
	
	public void addLog(BusinessLog log){
		logs.add( log );
	}
	
	public List<BusinessLog> getLogs(){
		return logs;
	}
	
	public static class BusinessLog {
		private Long entityId;
		private String entityType;
		private String logInfo;
		private Object operateEntity;
		
		public Long getEntityId() {
			return entityId;
		}
		public void setEntityId(Long entityId) {
			this.entityId = entityId;
		}
		public String getEntityType() {
			return entityType;
		}
		public void setEntityType(String entityType) {
			this.entityType = entityType;
		}
		
		public String getLogInfo() {
			return logInfo;
		}
		public void setLogInfo(String logInfo) {
			this.logInfo = logInfo;
		}
		public Object getOperateEntity() {
			return operateEntity;
		}
		public void setOperateEntity(Object operateEntity) {
			this.operateEntity = operateEntity;
		}
	}
}
