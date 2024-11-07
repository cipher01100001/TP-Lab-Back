package org.culturemedia.service.impl;

import org.culturemedia.exception.VideoNotFoundException;
import org.culturemedia.model.Video;
import org.culturemedia.model.View;
import org.culturemedia.repository.VideoRepository;
import org.culturemedia.repository.ViewsRepository;
import org.culturemedia.service.CulturemediaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CulturemediaServiceImpl implements CulturemediaService {

    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CulturemediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found.");
        }
        return videos;
    }

    @Override
    public Video save(Video video) {
        videoRepository.save(video);
        return video;
    }

    @Override
    public View save(View view) {
        viewsRepository.save(view);
        return view;
    }

    @Override
    public List<Video> find(String title) throws VideoNotFoundException {
        List<Video> videos = videoRepository.find( title );
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found.");
        }
        return videos;
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> videos = videoRepository.find( fromDuration, toDuration );
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found.");
        }
        return videos;
    }
}