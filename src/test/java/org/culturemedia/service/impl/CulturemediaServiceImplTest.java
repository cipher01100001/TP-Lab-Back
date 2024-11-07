package org.culturemedia.service.impl;

import org.culturemedia.exception.VideoNotFoundException;
import org.culturemedia.model.Video;
import org.culturemedia.repository.VideoRepository;
import org.culturemedia.repository.ViewsRepository;
import org.culturemedia.service.CulturemediaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CulturemediaServiceImplTest {

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private ViewsRepository viewsRepository;

    private CulturemediaService culturemediaService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewsRepository);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        mock_findAll_videos_returned_successfully();

        List<Video> videos = culturemediaService.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findAll());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() throws VideoNotFoundException {
        mock_FindByTitle_videos_returned_successfully("Clic");

        List<Video> videos = culturemediaService.find( "Clic" );
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.find("Clic"));
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() throws VideoNotFoundException {
        mock_FindByDuration_videos_returned_successfully( 4.5, 5.5 );

        List<Video> videos = culturemediaService.find( 4.5, 5.5 );
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.find( 4.5, 5.5 ));
    }

    private void mock_findAll_videos_returned_successfully() {
        doReturn(List.of(
                        new Video("01", "Título 1", "----", 4.5),
                        new Video("02", "Título 2", "----", 5.5),
                        new Video("03", "Título 3", "----", 4.4),
                        new Video("04", "Título 4", "----", 3.5),
                        new Video("05", "Clic 5", "----", 5.7),
                        new Video("06", "Clic 6", "----", 5.1)))
                .when(videoRepository)
                .findAll();
    }

    private void mock_FindByTitle_videos_returned_successfully(String title) {
        doReturn(List.of(
                        new Video("05", "Clic 5", "----", 5.7),
                        new Video("06", "Clic 6", "----", 5.1)))
                .when(videoRepository)
                .find(title);
    }

    private void mock_FindByDuration_videos_returned_successfully(Double fromDuration, Double toDuration) {
        doReturn(List.of(
                        new Video("03", "Título 3", "----", 4.4),
                        new Video("04", "Título 4", "----", 3.5),
                        new Video("05", "Clic 5", "----", 5.7)))
                .when(videoRepository)
                .find(fromDuration, toDuration);
    }
}