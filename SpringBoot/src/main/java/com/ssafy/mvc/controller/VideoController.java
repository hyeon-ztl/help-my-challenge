package com.ssafy.mvc.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.service.ReviewService;
import com.ssafy.mvc.model.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-video")
@Tag(name="VideoController")
@CrossOrigin("*")
public class VideoController {
	
	private final VideoService videoService;

	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("/video")
	@Operation(summary="전체 영상을 조회한다.")
	public ResponseEntity<?> searchAllVideo() {
		SearchCondition noCondition = new SearchCondition(); // 검색 조건으로 아무것도 넣지 않는다.
		List<Video> list = videoService.searchVideo(noCondition);
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("영상이 없습니다.", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/video/{videoId}")
	@Operation(summary="해당 영상을 조회한다.")
	public ResponseEntity<?> searchVideoByVideoId(@PathVariable("videoId") String videoId) {
		Video video = videoService.searchVideoByVideoId(videoId);
		
		if(video != null) {
			return new ResponseEntity<Video>(video, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("찾으시는 영상이 없습니다.", HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/video/search")
	@Operation(summary="검색 조건에 맞는 영상을 조회한다.")
	public ResponseEntity<?> searchByCondition(@ModelAttribute SearchCondition condition) {
		List<Video> list = videoService.searchVideo(condition);
		
		if(list != null && list.size() > 0) {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("검색 조건에 맞는 영상이 없습니다.", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/video")
	@Operation(summary="새로운 영상을 등록한다.")
	public ResponseEntity<?> registVideo(@RequestBody Video video) {
		if(videoService.registVideo(video)) {
			return new ResponseEntity<Video>(video, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("영상 등록에 실패하였습니다.", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/video")
	@Operation(summary="해당 영상을 수정한다.")
	public ResponseEntity<?> modifyVideo(@RequestBody Video video) {		
		if(videoService.modifyVideo(video)) {
			return new ResponseEntity<String>("영상 수정에 성공하였습니다.", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("영상 수정에 실패하였습니다.", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/video/{videoId}")
	@Operation(summary="해당 영상을 삭제한다.")
	public ResponseEntity<String> removeVideo(@PathVariable("videoId") int videoId) {
		if(videoService.removeVideo(videoId)) {
			return new ResponseEntity<String>("영상 삭제에 성공하였습니다.", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("영상 삭제에 실패하였습니다.", HttpStatus.BAD_REQUEST);
	}
	
}
