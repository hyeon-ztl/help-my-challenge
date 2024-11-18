package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.VideoDao;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	private VideoDao dao;
	
	public VideoServiceImpl(VideoDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Video> searchVideo(SearchCondition condition) {
		return dao.selectVideo(condition);
	}

	@Override
	public Video searchVideoByVideoId(String videoId) {
		return dao.selectVideoByVideoId(videoId);
	}
	
	@Override
	public boolean registVideo(Video video) {
		return dao.insertVideo(video) > 0;
	}

	@Override
	public boolean modifyVideo(Video video) {
		return dao.updateVideo(video) > 0;
	}

	@Override
	public boolean removeVideo(int videoId) {
		return dao.deleteVideo(videoId) > 0;
	}


}
