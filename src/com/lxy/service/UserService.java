package com.lxy.service;

import java.util.List;
import java.util.Map;

import com.lxy.model.LxyProductDetail;
import com.lxy.model.LxyUser;

public interface UserService {
	
	public LxyUser selectByPrimaryKey(Long id);
	
	public List<LxyUser> getUserByParam(Map<String, Object> param);
	
	public List<LxyProductDetail> getImgPaths(Map<String, Object> param);
	
}
