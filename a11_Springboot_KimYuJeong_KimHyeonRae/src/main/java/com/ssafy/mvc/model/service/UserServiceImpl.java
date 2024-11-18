//package com.ssafy.mvc.model.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//
//import com.ssafy.mvc.model.dao.UserDao;
//import com.ssafy.mvc.model.dto.User;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	private final UserDao userDao;
//	
//	public UserServiceImpl (UserDao userDao) {
//		this.userDao = userDao;
//	}
//	
//	@Override
//	public boolean signUp(User user) {
//		int num = userDao.insertUser(user);
//		
//		if(num <= 0 ) return false;
//		return true;
//	}
//
//	@Override
//	public User login(String userId, String password) {
//		Map<String, String> info = new HashMap();
//		info.put("userId", userId);
//		info.put("password", password);
//	
//		User tmp = userDao.selectOne(info);
//		return tmp;
//	}
//
//}
