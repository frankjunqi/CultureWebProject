package com.lxy.util;

import org.springframework.beans.factory.BeanFactoryAware;

//public class SpringContextProxy implements BeanFactoryAware{
	/*
	private BeanFactory beanFactory;
	
	private static SpringContextProxy instance;
	
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		this.beanFactory = arg0;
		instance = this;
	}
	
	public static SpringContextProxy getInstance() {
		return instance;
	}
	
	public BaseDAO getCommonDAO(){
		return (BaseDAO) getBean("baseDAO");
	}
	
	public Object getBean(String name){
		return beanFactory.getBean(name);
	}
	
	public Object getBean(Class<?> clzz){
		return getBean(clzz.getName());
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}
}*/
