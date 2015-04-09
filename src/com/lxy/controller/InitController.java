package com.lxy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxy.model.LxyCompanyNews;
import com.lxy.service.NewsService;
import com.lxy.service.ProductService;

@Controller
@RequestMapping("initWebSite")
public class InitController {
	
	private NewsService newsService;
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@RequestMapping("homePageInitAction")
	public @ResponseBody Map<String, Object> homePageInitAction(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		// 首页新闻，加载10条
		List<LxyCompanyNews> newsList = newsService.getNewsByParam(param);
		List<Map<String, Object>> productMap = productService.getProductByParams(param);
		// 加载需要展示的产品
		resultMap.put("newsList", newsList);
		return resultMap;
	}
	
}
