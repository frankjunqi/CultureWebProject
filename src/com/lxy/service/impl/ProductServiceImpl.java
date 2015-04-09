package com.lxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.mapper.LxyProductDetailMapper;
import com.lxy.mapper.LxyProductMapper;
import com.lxy.model.LxyProduct;
import com.lxy.model.LxyProductDetail;
import com.lxy.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	private LxyProductMapper lxyProductMapper;
	
	private LxyProductDetailMapper lxyProductDetailMapper;
	
	@Autowired
	public void setLxyProductDetailMapper(
			LxyProductDetailMapper lxyProductDetailMapper) {
		this.lxyProductDetailMapper = lxyProductDetailMapper;
	}

	@Autowired
	public void setLxyProductMapper(LxyProductMapper lxyProductMapper) {
		this.lxyProductMapper = lxyProductMapper;
	}

	@Override
	public LxyProduct selectByPrimaryKey(Long id) {
		return lxyProductMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LxyProductDetail> getImgPaths(Map<String, Object> param) {
		
		return lxyProductDetailMapper.getImgPaths(param);
	}

	@Override
	public List<LxyProduct> getProductByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(LxyProduct lxyProduct) {
		lxyProductMapper.insert(lxyProduct);
	}

	@Override
	public List<Map<String, Object>> getProductByParams(
			Map<String, Object> param) {
		return lxyProductMapper.getProductByParams(param);
	}

	@Override
	public void update(LxyProduct lxyProduct) {
		lxyProductMapper.updateByPrimaryKeySelective(lxyProduct);
	}

}
