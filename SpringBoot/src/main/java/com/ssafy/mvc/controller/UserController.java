//package com.ssafy.mvc.controller;
//
//import java.util.HashMap;
//
//import java.util.Map;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ssafy.mvc.jwt.JwtUtil;
//import com.ssafy.mvc.model.dto.User;
//import com.ssafy.mvc.model.service.UserService;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@RestController 
//@RequestMapping("/api-user")
//@Tag(name="UserController")
//@CrossOrigin("*")
//public class UserController {
//	
//	private final UserService userService;
//	private final JwtUtil jwtUtil;
//	
//	public UserController(UserService userService, JwtUtil jwtUtil) {
//		this.userService = userService;
//		this.jwtUtil = jwtUtil;
//	}
//
//	@PostMapping("/user/login")
//	@Operation(summary="로그인합니다.")
//	public ResponseEntity<?> login(@RequestBody User user){
//		User loginUser = userService.login(user.getUserId(), user.getPassword());
//		Map<String, Object> result = new HashMap<>();		
//		
//	    if (loginUser != null) {
//	    	result.put("access-token", jwtUtil.createToken(loginUser.getName(), loginUser.getUserId()));
//	        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
//	    }
//	        
//	    return new ResponseEntity<String>("로그인 실패: 사용자 ID 또는 비밀번호를 확인하세요.", HttpStatus.BAD_REQUEST);
//	    	
//	}
//	
//	@PostMapping("/user/signup")
//	@Operation(summary="새로운 사용자를 등록합니다.")
//	public  ResponseEntity<?> signUp (@RequestBody User user) {
//		
//		System.out.println(user);
//
//		boolean isTrue = userService.signUp(user);
//		
//		if(isTrue) { // 성공
//			return new ResponseEntity<User>( user ,HttpStatus.CREATED);
//		}
//		else {// 실패
//			return new ResponseEntity<String>("회원가입 실패" , HttpStatus.INTERNAL_SERVER_ERROR);
//			
//		}
//			}
//}
