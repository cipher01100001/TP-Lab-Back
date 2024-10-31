package org.culturemedia.controllers;

import java.util.List;

import org.culturemedia.exception.VideoNotFoundException;
import org.culturemedia.model.Video;
import org.culturemedia.service.CulturemediaService;

public class CultureMediaController {

	private final CulturemediaService cultureMediaService;

	public CultureMediaController(CulturemediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}

	public List<Video> findAllVideos() throws VideoNotFoundException {
		List<Video> videos;
		videos = cultureMediaService.findAll();
		return videos;
	}
}
