package com.lxy.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;


public abstract class IntervalLogger implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		long starting = System.currentTimeMillis();
		Object o = invocation.proceed();
		long interval = System.currentTimeMillis() - starting;
		String invocationClassName = getInvocationClassName(invocation);
		String invocationMethodName = getInvocationMethodName(invocation);
		
		Logger.getLogger(this.getClass()).info(invocationClassName + "," + invocationMethodName + "," + interval);
		return o;
	}

	public abstract String getInvocationMethodName(MethodInvocation invocation);

	public String getInvocationClassName(MethodInvocation invocation) {
		String invocationClassName = invocation.getThis().toString();
		String convertedClassName = null;
		int truncatePosition = invocationClassName.indexOf("@");
		// truncate to filted the string that follows @
		if (truncatePosition != -1)
			convertedClassName = invocationClassName.substring(0, truncatePosition);
		else
			convertedClassName = invocationClassName;

		return convertedClassName;
	}
}
