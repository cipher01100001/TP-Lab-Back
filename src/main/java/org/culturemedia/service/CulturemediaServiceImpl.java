package org.culturemedia.service;

import org.culturemedia.exception.DurationNotValidException;
import org.culturemedia.exception.VideoNotFoundException;
import org.culturemedia.model.Video;
import org.culturemedia.model.View;
import org.culturemedia.repository.VideoRepository;
import org.culturemedia.repository.ViewsRepository;

import java.text.MessageFormat;
import java.util.List;

public class CulturemediaServiceImpl implements CulturemediaService{

    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CulturemediaServiceImpl( VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video save(Video video) throws DurationNotValidException {
        if (video.duration() <= 0)
            throw new DurationNotValidException(MessageFormat.format("The video duration is not valid: {0}", video.duration()));
        return videoRepository.save(video);
    }

    @Override
    public View save(View view) throws VideoNotFoundException {
        Video video = view.video();
        if (videoRepository.find(video.title()).isEmpty()) {
            throw new VideoNotFoundException(MessageFormat.format("Video not found: {0}", video.duration()));
        }
        return viewsRepository.save(view);
    }
}