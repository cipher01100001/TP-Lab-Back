package org.culturemedia.service;

import org.culturemedia.exception.DurationNotValidException;
import org.culturemedia.exception.VideoNotFoundException;
import org.culturemedia.model.Video;
import org.culturemedia.model.View;

import java.util.List;

public interface CulturemediaService {
    List<Video> findAll();
    Video save(Video video) throws DurationNotValidException;
    View save(View view) throws VideoNotFoundException;
}