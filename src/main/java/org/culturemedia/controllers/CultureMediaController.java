package org.culturemedia.controllers;

import java.util.List;

import org.culturemedia.exception.VideoNotFoundException;
import org.culturemedia.model.Video;
import org.culturemedia.service.CulturemediaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {

	private final CulturemediaService cultureMediaService;

	public CultureMediaController(CulturemediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}

	@GetMapping("/videos")
	public List<Video> findAllVideos() throws VideoNotFoundException {
		List<Video> videos;
		videos = cultureMediaService.findAll();
		return videos;
	}

	@PostMapping("/videos")
	public Video save(@RequestBody Video video){
		cultureMediaService.save(video);
		return video;
	}
}