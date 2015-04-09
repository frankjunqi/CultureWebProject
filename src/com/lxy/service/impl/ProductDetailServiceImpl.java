package com.lxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.mapper.LxyProductDetailMapper;
import com.lxy.model.LxyProductDetail;
import com.lxy.service.ProductDetailService;

@Service("productDetailService")
public class ProductDetailServiceImpl implements ProductDetailService{
	
	private LxyProductDetailMapper lxyProductDetailMapper;

	@Autowired
	public void setLxyProductDetailMapper(
			LxyProductDetailMapper lxyProductDetailMapper) {
		this.lxyProductDetailMapper = lxyProductDetailMapper;
	}

	@Override
	public void insert(LxyProductDetail productDetail) {
		lxyProductDetailMapper.insert(productDetail);
	}

}
