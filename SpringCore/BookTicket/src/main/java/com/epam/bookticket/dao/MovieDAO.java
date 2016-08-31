package com.epam.bookticket.dao;

import com.epam.bookticket.bean.Movie;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Полина on 31.08.2016.
 */
public interface MovieDAO {
    Movie add(String name, String description, LocalDateTime startDate, Set<Long> availableSit);
    void delete(Long id);
    Movie getMovieById(Long movieId);
}
