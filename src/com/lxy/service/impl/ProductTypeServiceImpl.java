package com.lxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.mapper.LxyProductTypeMapper;
import com.lxy.service.ProductTypeService;

@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService{

	private LxyProductTypeMapper lxyProductTypeMapper;
	
	@Autowired
	public void setLxyProductTypeMapper(LxyProductTypeMapper lxyProductTypeMapper) {
		this.lxyProductTypeMapper = lxyProductTypeMapper;
	}

	@Override
	public List<Map<String, Object>> loadProductType(Map<String, Object> param) {
		return lxyProductTypeMapper.loadProductType(param);
	}

	@Override
	public List<Map<String, Object>> getRootProductType(
			Map<String, Object> param) {
		return lxyProductTypeMapper.getRootProductType(param);
	}
}
