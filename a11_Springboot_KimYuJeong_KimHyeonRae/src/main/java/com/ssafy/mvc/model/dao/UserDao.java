package com.ssafy.mvc.model.dao;

import java.util.Map;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {
	
	public User selectOne(Map<String, String> info);
	
	public int insertUser(User user);

}
