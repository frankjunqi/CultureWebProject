package com.lxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.mapper.LxyCompanyNewsMapper;
import com.lxy.model.LxyCompanyNews;
import com.lxy.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService{

	private LxyCompanyNewsMapper lxyCompanyNewsMapper;

	@Autowired
	public void setLxyCompanyNewsMapper(LxyCompanyNewsMapper lxyCompanyNewsMapper) {
		this.lxyCompanyNewsMapper = lxyCompanyNewsMapper;
	}

	@Override
	public List<LxyCompanyNews> getNewsByParam(Map<String, Object> param) {
		return lxyCompanyNewsMapper.getNewsByParam(param);
	}

}
