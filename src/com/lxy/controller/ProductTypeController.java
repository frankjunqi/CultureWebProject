package com.lxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxy.service.ProductTypeService;
import com.lxy.util.ValidateUtil;

@Controller
@RequestMapping("productType")
public class ProductTypeController extends BaseAction {
	
	private ProductTypeService productTypeService;
	
	Logger logger = Logger.getLogger(ProductTypeController.class);
	
	@Autowired
	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	@RequestMapping("getRootProductType")
	public @ResponseBody List<Map<String, Object>> getRootProductType(HttpServletRequest request,HttpServletResponse response){
		logger.info("--------ProductTypeController getRootProductType start---------");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		logger.info("--------ProductTypeController getRootProductType end---------");
		return productTypeService.getRootProductType(paramMap);
	}
	
	@RequestMapping("loadProductType")
	public @ResponseBody List<Map<String, Object>> loadProductType(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(ValidateUtil.isNotEmpty(request.getParameter("operId"))){
			paramMap.put("operId", request.getParameter("operId"));
		}
		if(ValidateUtil.isNotEmpty(request.getParameter("typeId"))){
			paramMap.put("typeId", request.getParameter("typeId"));
		}
		if(ValidateUtil.isNotEmpty(request.getParameter("parentTypeId"))){
			paramMap.put("parentTypeId", request.getParameter("parentTypeId"));
		}
		
		List<Map<String, Object>> typeList = new ArrayList<Map<String, Object>>();
		typeList = productTypeService.loadProductType(paramMap);
		return typeList;
	}

	@Override
	public List<String[]> getDownloadData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}  

}
