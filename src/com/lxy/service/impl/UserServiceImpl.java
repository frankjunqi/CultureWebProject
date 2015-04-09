package com.lxy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.mapper.LxyProductDetailMapper;
import com.lxy.mapper.LxyUserMapper;
import com.lxy.model.LxyProductDetail;
import com.lxy.model.LxyUser;
import com.lxy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	private LxyUserMapper lxyUserMapper;
	
	private LxyProductDetailMapper lxyProductDetailMapper;
	
	@Autowired
	public void setLxyProductDetailMapper(
			LxyProductDetailMapper lxyProductDetailMapper) {
		this.lxyProductDetailMapper = lxyProductDetailMapper;
	}

	@Autowired
	public void setLxyUserMapper(LxyUserMapper lxyUserMapper) {
		this.lxyUserMapper = lxyUserMapper;
	}

	@Override
	public LxyUser selectByPrimaryKey(Long id) {
		return lxyUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LxyUser> getUserByParam(Map<String, Object> param) {
		return lxyUserMapper.getUserByParam(param);
	}

	@Override
	public List<LxyProductDetail> getImgPaths(Map<String, Object> param) {
		
		return lxyProductDetailMapper.getImgPaths(param);
	}

}
