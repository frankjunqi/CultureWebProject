package com.lxy.service;

import java.util.List;
import java.util.Map;

import com.lxy.model.LxyProduct;
import com.lxy.model.LxyProductDetail;

public interface ProductService {
	
	public LxyProduct selectByPrimaryKey(Long id);
	
	public List<LxyProduct> getProductByParam(Map<String, Object> param);
	
	public List<LxyProductDetail> getImgPaths(Map<String, Object> param);
	
	public void insert(LxyProduct lxyProduct);
	
	public void update(LxyProduct lxyProduct);
	
	/**
	 * get product by params
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getProductByParams(Map<String, Object> param);
	
}
