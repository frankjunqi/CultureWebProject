package com.lxy.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Tracer {
	public static final String WORK_HOME = System.getProperty( "WORK_HOME" );
	static Logger logger;
	static Logger errorLogger;
	private static Level mlevel;

	static{
		try{
			PropertyConfigurator.configure(WORK_HOME + "/etc/conf/log4j.properties");
			logger = Logger.getLogger(Tracer.class.getName());
			errorLogger = Logger.getLogger(Tracer.class.getName() + ".error");
			mlevel = logger.getLevel();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static void error(Object message){
		errorLogger.error(message);
	}

	public static void error(Throwable t){
		if (t != null){
			errorLogger.error(t.getMessage(), t);
		}
	}

	/**
	 * <p>Logs the given message with a trace level of <code>WARN</code>.</p>
	 * 
	 * @param message the message to be logged
	 */
	public static void warn(Object message)
	{
		if ((mlevel == Level.DEBUG) || (mlevel == Level.INFO) || (mlevel == Level.WARN))
		{
			logger.warn(message);
		}
	}

	/**
	 * <p>Logs the given message with a trace level of <code>INFO</code>.</p>
	 * 
	 * @param message the message to be logged
	 */
	public static void info(Object message)
	{
		if ((mlevel == Level.DEBUG) || (mlevel == Level.INFO))
		{

			logger.info(message);
		}
	}

	/**
	 * <p>Logs the given message with a trace level of <code>DEBUG</code>.</p>
	 * 
	 * @param message the message to be logged
	 */
	public static void debug(Object message)
	{
		if (mlevel == Level.DEBUG)
		{

			logger.debug(message);
		}
	}


	/**
	 * <p>Gets the stack trace of the given throwable in the form of a <code>String</code>.</p> 
	 * 
	 * @param t the throwable of which to obtain the stack trace
	 * 
	 * @return string representation of the stack trace of <code>e</code>
	 */
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
}

