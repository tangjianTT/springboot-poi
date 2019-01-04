package com.poi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.poi.po.User;

@Mapper
public interface UserMapper {


	int addUsers(@Param(value="user")  List<User> user);
}
