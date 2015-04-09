package com.lxy.log;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

public class LogUtil {

    protected static Logger defaultLogger = Logger.getLogger(LogUtil.class);
    
    public static void logError(Object o,Throwable t,Class<?> c){
    	Logger log = null;
    	if(c != null){
    		log = Logger.getLogger(c);
    	} else {
    		log = defaultLogger;
    	}
    	log.error(o, t);
    }
    public static void debug(Object o){
    	defaultLogger.debug(o);
    }
    
    public static void logInfo(Object o,Class<?> c){
    	Logger log = null;
    	if(c != null){
    		log = Logger.getLogger(c);
    	} else {
    		log = defaultLogger;
    	}
    	log.info(o);
    }
    
    public static void logError(Object o,Throwable t){
    	logError(o, t, null);
    }
    public static void logInfo(Object o){
    	logInfo(o, null);
    }

    public static String stack2string(Throwable t)
	{
		try
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);

			return sw.toString();
		}
		catch (Throwable t2)
		{
			return "Trace.stack2string Exception";
		}
	}

    @SuppressWarnings("unchecked")
	public static void processExceptionMap( Map<?, Exception> eMap )throws RuntimeException{
        if( eMap != null && eMap.size() > 0 ) {
			String eDescription = new String();
			
			Iterator<?> iter = eMap.entrySet().iterator();
			while ( iter.hasNext() ) {
				Map.Entry<?, Exception> entry = (Map.Entry<?, Exception>)iter.next();
				
				String id = entry.getKey().toString();
                Exception e = entry.getValue();
                eDescription += "ID:" + id + "|Exception Message:" + stack2string(e)+"\n";

                logException(e);
            }
			
			throw new RuntimeException(eDescription);
		}
    }

    public static void logException(Throwable exception){
        logException(exception, null);
    }
    public static void logException(Throwable exception, Logger logger){
        if (logger == null)
            logger = defaultLogger;

        String messageText = exception.getMessage();

        Throwable tCause = exception;
        while ((messageText == null) && (tCause.getCause() != null)) {
            /*
            * When the Exception has no message, maybe its cause has one
            */
            tCause = exception.getCause();
            messageText = tCause.getMessage();
        }

        logger.error("Exception: "+messageText);
        logger.error("Stack Trace:");
        logger.error(LogUtil.stack2string(exception));

    }
    
    public static String getExceptionDes(Throwable exception){
    	String messageText = exception.getMessage();

        Throwable tCause = exception;
        while ((messageText == null) && (tCause.getCause() != null)) {
            /*
            * When the Exception has no message, maybe its cause has one
            */
            tCause = exception.getCause();
            messageText = tCause.getMessage();
        }
        
        return "Exception: "+messageText + "\nStack Trace:" + stack2string(exception);
    }
	public static void info(Object obj) {
		defaultLogger.info(obj);
	}
}
