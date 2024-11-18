package com.ssafy.mvc.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="리뷰 객체입니다.")
public class Review {
	private int reviewId;
	private String email;
	private String content;
	private String videoId;
	
	public Review() {}

	public Review(int reviewId, String email, String content, String videoId) {
		this.reviewId = reviewId;
		this.email = email;
		this.content = content;
		this.videoId = videoId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", email=" + email + ", content=" + content + ", videoId=" + videoId + "]";
	}
	
}
