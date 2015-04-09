package com.lxy.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxy.model.LxyUser;
import com.lxy.service.UserService;
import com.lxy.util.ValidateUtil;

@Controller
@RequestMapping("user")
public class UserController extends BaseAction {
	
	private UserService userService;
	
	Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("login")
	public @ResponseBody String login(HttpServletRequest request,HttpServletResponse response){
		logger.info("-------------- start UserController login ---------------");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(ValidateUtil.isNotEmpty(request.getParameter("password"))){
			paramMap.put("password", request.getParameter("password"));
		}
		if(ValidateUtil.isNotEmpty(request.getParameter("userName"))){
			paramMap.put("operId", request.getParameter("userName"));
		}
		String result = null;
		List<LxyUser> userlist = userService.getUserByParam(paramMap);
		if(ValidateUtil.isNotEmpty(userlist)){
			result = "success";
		}else{
			result = "failed";
		}
		logger.info("-------------- end UserController login ---------------");
		return result;
	}

	@Override
	public List<String[]> getDownloadData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	
	 //接收前台传过来的字符串格式的json对象，在后台进行解析  
   @RequestMapping("/resolveJsonObject")  
   public void resolveJsonObject(HttpServletRequest request,HttpServletResponse response) throws IOException {  
       //解码  
   	String userName = request.getParameter("userName");
   	System.out.println(userName);
//       String str = URLDecoder.decode(request.getParameter("orderJson"),"UTF-8");  
//       JSONObject jb=new JSONObject();   
       //将json格式的字符串转换为json对象，并取得该对象的“userName”属性值  
//       String o=(String)jb.fromObject(str).get("userName");  
//       System.out.println(o);  
   }   
     
    //传递json数组字符串  
   @RequestMapping("/resolveJsonArray" )  
   public void resolveJsonArray(HttpServletRequest request,HttpServletResponse response) throws IOException {  
       //解码，为了解决中文乱码  
       String str = URLDecoder.decode(request.getParameter("orderJson"),"UTF-8");  
       JSONObject jb=new JSONObject();  
       //将json格式的字符串转换为json数组对象  
//       JSONArray array=(JSONArray)jb.fromObject(str).get("menu");  
       //取得json数组中的第一个对象  
//       JSONObject o = (JSONObject) array.get(0);//获得第一个array结果  
       //取出json数组中第一个对象的“userName”属性值  
//       String name=o.get("userName").toString();//获得属性值  
//       System.out.println(name);  
   }   
     
   //通过该函数返回json格式的数据，在前台通过JQuery进行解析  
   @RequestMapping("/resolveJson"  )  
   public void resolveJson(HttpServletRequest request,HttpServletResponse response) throws IOException {  
         
       List m = (List) new  ArrayList();  
       JSONArray jsons = new JSONArray();  
       for(int i=0;i<10;i++){  
//           User user = new User();  
//           user.setUserName("name_" + i);  
//           m.add(user);  
       }  
         
       for(int j=0;j<m.size();j++){  
           JSONObject jsonObject = new JSONObject();  
//           jsonObject.put("user", m.get(j));  
//           jsons.add(jsonObject);  
       }  
       response.getWriter().print(jsons.toString()) ;   
   }   
   
}
