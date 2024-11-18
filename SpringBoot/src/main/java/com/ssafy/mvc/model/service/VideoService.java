package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.Video;

public interface VideoService {
	
	// 영상 조회
	List<Video> searchVideo(SearchCondition condition);
	
	// id로 영상 조회
	Video searchVideoByVideoId(String videoId);
	
	// 영상 등록
	boolean registVideo(Video video);
	
	// 영상 수정
	boolean modifyVideo(Video video);
	
	// 영상 삭제
	boolean removeVideo(int videoId);
	
}
