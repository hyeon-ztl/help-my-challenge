package com.ssafy.mvc.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="영상 객체입니다.")
public class Video {
	private int videoId;
	private String title;
	private String youtubeUrl;
	private String channelName;
	private int viewCnt;
	private int partCode;
	private String partName;
	
	public Video() {
	}

	public Video(int videoId, String title, String youtubeUrl, String channelName, int viewCnt, int partCode, String partName) {
		this.videoId = videoId;
		this.title = title;
		this.youtubeUrl = youtubeUrl;
		this.channelName = channelName;
		this.viewCnt = viewCnt;
		this.partCode = partCode;
		this.partName = partName;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	public int getPartCode() {
		return partCode;
	}
	
	public void setPartCode(int partCode) {
		this.partCode = partCode;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", youtubeUrl=" + youtubeUrl + ", channelName="
				+ channelName + ", viewCnt=" + viewCnt + ", partCode=" + partCode + ", partName=" + partName + "]";
	}
	
}
