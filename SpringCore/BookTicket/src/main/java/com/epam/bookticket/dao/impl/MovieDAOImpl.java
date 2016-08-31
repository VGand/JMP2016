package com.epam.bookticket.dao.impl;

import com.epam.bookticket.bean.Movie;
import com.epam.bookticket.dao.MovieDAO;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Полина on 31.08.2016.
 */
@Repository
public class MovieDAOImpl implements MovieDAO{
    private Map<Long, Movie> movieMap;
    private Long movieSequence = 0L;

    public MovieDAOImpl() {
        movieMap = new HashMap<Long, Movie>();
    }

    public Movie add(String name, String description, LocalDateTime startDate, Set<Long> availableSit) {
        Movie movie = new Movie(name, movieSequence++, description, startDate, availableSit);
        movieMap.put(movie.getId(), movie);
        return movie;
    }


    public void delete(Long id) {
        movieMap.remove(id);
    }

    public Movie getMovieById(Long movieId) {
        return movieMap.get(movieId);
    }
}
