package com.poi.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poi.mapper.UserMapper;
import com.poi.po.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public int insertUsers(List<User> allUsers){
		for (User user : allUsers) {
			System.out.println(user);
		}
		return userMapper.addUsers(allUsers);
	}
}
