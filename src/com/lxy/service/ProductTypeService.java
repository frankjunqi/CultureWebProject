package com.lxy.service;

import java.util.List;
import java.util.Map;

public interface ProductTypeService {
	
	public List<Map<String, Object>> loadProductType(Map<String, Object> param);

	public List<Map<String, Object>> getRootProductType(Map<String, Object> param);

}
