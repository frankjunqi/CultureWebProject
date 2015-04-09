package com.lxy.service;

import java.util.List;
import java.util.Map;

import com.lxy.model.LxyCompanyNews;

public interface NewsService {
	
	/**
	 * get news by param
	 * @param param
	 * @return
	 */
	public List<LxyCompanyNews> getNewsByParam(Map<String, Object> param);

}
