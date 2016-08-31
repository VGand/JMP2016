package com.epam.bookticket.service;

import com.epam.bookticket.bean.Movie;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Полина on 31.08.2016.
 */
public interface MovieManager {
    Set<Long> getAvailableSit(Long movieId);
    Movie addMovie(String name, String description, LocalDateTime startDateTime, Set<Long> availableSit);
}
