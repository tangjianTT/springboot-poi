package com.poi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poi.po.User;
import com.poi.service.UserService;
import com.poi.util.POIUtil;

@RestController
@RequestMapping("/read")
class FileController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 读取excel文件中的用户信息，保存在数据库中
	 * @param excelFile
	 */
	@RequestMapping("/hello")
	public String  hello()
	{
		return "hello";
	}
	
	@RequestMapping("/readExcel")
	public void readExcel(@RequestParam(value = "excelFile") MultipartFile excelFile,HttpServletRequest req,HttpServletResponse resp){
/*	    Map<String, Object> param = new HashMap<String, Object>();
*/	    List<User> allUsers = new ArrayList<User>();
	    try {
		    List<String[]> userList = POIUtil.readExcel(excelFile);
		    for(int i = 0;i<userList.size();i++){
			  String[] users = userList.get(i);
			  User user = new User();
			  user.setUserName(users[0]);
			  user.setPassword(users[1]);
			  user.setAge(Integer.parseInt(users[2]));
			  allUsers.add(user);
		     }
		   } catch (IOException e) {
		 e.printStackTrace();
	       }
	   /*  param.put("allUsers", allUsers);*/
	     this.userService.insertUsers(allUsers);
	}


}
