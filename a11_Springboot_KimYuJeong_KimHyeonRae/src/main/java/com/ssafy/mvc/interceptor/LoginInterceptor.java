//package com.ssafy.mvc.interceptor;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import com.ssafy.mvc.jwt.jwtUtil;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//
//    private final String HEADER_AUTH = "access-token"; // header에서 token을 가져오기 위함
//    
//    private final jwtUtil jwtUtil;
//
//    public LoginInterceptor(jwtUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }
//    
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        
//        // CORS 문제 해결을 위해 OPTIONS 메서드는 항상 허용
//        if(request.getMethod().equalsIgnoreCase("OPTIONS")) return true;
//        
//        // POST, PUT, DELETE 요청일 때만 토큰 검증
//        String method = request.getMethod();
//        if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method) || "DELETE".equalsIgnoreCase(method)) {
//            String token = request.getHeader(HEADER_AUTH);
//            
//            // 토큰이 존재하고 유효한 경우에만 요청을 허용
//            if (token != null) {
//            	jwtUtil.validate(token);
//                return true;
//            }
//            
//            return false;
//        }
//
//        // GET, HEAD 등의 다른 메서드는 검증 없이 허용
//        return true;
//    }
//}
