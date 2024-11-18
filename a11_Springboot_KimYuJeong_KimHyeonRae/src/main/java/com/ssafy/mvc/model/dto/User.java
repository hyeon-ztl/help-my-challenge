package com.ssafy.mvc.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="사용자 객체입니다.")
public class User {
	private String userId;
	private String password;
	private String name;
	private String nickname;
	
	public User() {}
	
	public User(String userId, String password, String name, String nickname) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}
