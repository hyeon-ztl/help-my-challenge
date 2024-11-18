package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.Video;

public interface VideoDao {
	
	// 영상 조회
	List<Video> selectVideo(SearchCondition condition);
	
	// id로 영상 조회
	Video selectVideoByVideoId(String videoId);
	
	// 영상 등록
	int insertVideo(Video video);
	
	// 영상 수정
	int updateVideo(Video video);
	
	// 영상 삭제
	int deleteVideo(int videoId);
	
}
