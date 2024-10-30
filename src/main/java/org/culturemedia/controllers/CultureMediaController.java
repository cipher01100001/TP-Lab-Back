package org.culturemedia.controllers;

import java.util.*;

import org.culturemedia.exception.VideoNotFoundException;
import org.culturemedia.model.Video;
import org.culturemedia.service.impl.CulturemediaServiceImpl;

public class CultureMediaController {

	private final CulturemediaServiceImpl cultureMediaService;


	public CultureMediaController(CulturemediaServiceImpl cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}


	public List<Video> find_allVideos() throws VideoNotFoundException {
		List<Video> videos = null;
		videos = cultureMediaService.findAll();
		return videos;
	}


}
