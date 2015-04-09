package com.lxy.controller;

import java.io.File;
import java.io.IOException;
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

import com.lxy.model.LxyProduct;
import com.lxy.model.LxyProductDetail;
import com.lxy.service.ProductDetailService;
import com.lxy.service.ProductService;
import com.lxy.util.FileUtil;
import com.lxy.util.ValidateUtil;

@Controller
@RequestMapping("product")
public class ProductController extends BaseAction {
	
	private ProductService productService;
	
	private ProductDetailService productDetailService;
	
	@Autowired
	public void setProductDetailService(ProductDetailService productDetailService) {
		this.productDetailService = productDetailService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	Logger logger = Logger.getLogger(ProductController.class);
	
	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("fileUpload")
	public @ResponseBody String fileUpload(HttpServletRequest request,HttpServletResponse response){
		String result = null;
		String productType = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productType"))){
			productType = request.getParameter("productType");//获取产品类型
		}
		String productSubType = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productType"))){
			productSubType = request.getParameter("productSubType");//获取产品子类
		}
		String productColor = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productType"))){
			productColor = request.getParameter("productColor");//获取产品颜色
		}
		String productSize = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productSize"))){
			productSubType = request.getParameter("productSize");//获取产品子类
		}
		String webProjectPath = request.getSession().getServletContext().getRealPath("/") + "productImages";//存储图片的根文件夹
		StringBuilder sb = new StringBuilder();
		StringBuilder fileNameSb = new StringBuilder();
		
		sb.append(webProjectPath).append(File.pathSeparator).append(productType + File.pathSeparator)
			.append(productSubType + File.pathSeparator).append(productColor + File.pathSeparator).append(productSize + File.pathSeparator);
		
		fileNameSb.append(productType == null ? "" : "_" + productType)
			.append(productSubType == null ? "" :  "_" + productSubType)
			.append(productColor == null ? "" : "_" + productColor)
			.append(productSize == null ? "" : "_" + productSize);
		
		try {
			String file = FileUtil.uploadFile(request, webProjectPath, "asdfasdf");
			saveFileInfo(file,request);
			result = "success";
		} catch (IllegalStateException e) {
			logger.error("上传 文件出错",e);
			result = "failed";
		} catch (IOException e) {
			logger.error("上传 文件出错",e);
			result = "failed";
		}
		return result;
	}
	
	/**
	 * saveFileInfo 保存图片信息
	 * @param file
	 * @param request
	 */
	private void saveFileInfo(String file,HttpServletRequest request){

		LxyProduct lxyProduct = new LxyProduct();
		LxyProductDetail productDetail = new LxyProductDetail();
		String productType = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productType"))){
			productType = request.getParameter("productType");//获取产品类型
		}
		String productSubType = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productSubType"))){
			productSubType = request.getParameter("productSubType");//获取产品子类
		}
		String productColor = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productColor"))){
			productColor = request.getParameter("productColor");//获取产品颜色
		}
		String productSize = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productSize"))){
			productSize = request.getParameter("productSize");//获取产品子类
		}
		String productName = null;
		if(ValidateUtil.isNotEmpty(request.getParameter("productName"))){
			productName = request.getParameter("productName");//获取产品子类
		}
		lxyProduct.setProductDesc("");
		lxyProduct.setVersion(0);
		lxyProduct.setProductTypeId(null);
		lxyProduct.setAmt("");
		lxyProduct.setProductName(productName);
		productService.insert(lxyProduct);
		productDetailService.insert(productDetail);
		
	}
	
	@RequestMapping("getImgPaths")
	public @ResponseBody List<LxyProductDetail> getImgPathsByParam(HttpServletRequest request,HttpServletResponse response){
		
		Map<String, Object> param = new HashMap<String, Object>();
		if(ValidateUtil.isNotEmpty(request.getParameter("type"))){
			param.put("type",String.valueOf(request.getParameter("type")));
		}
		if(ValidateUtil.isNotEmpty(request.getParameter("color"))){
			param.put("color",String.valueOf(request.getParameter("color")));
		}
		List<LxyProductDetail> lpd = productService.getImgPaths(param);
		return lpd;
	}
      
    @RequestMapping("/toJson"   )   
    public String toJson() {  
        return "/json";  
    }

	@Override
	public List<String[]> getDownloadData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}  

}
