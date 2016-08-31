package com.epam.bookticket.service.impl;

import com.epam.bookticket.bean.Movie;
import com.epam.bookticket.dao.MovieDAO;
import com.epam.bookticket.service.MovieManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Полина on 31.08.2016.
 */
@Component
public class MovieManagerImpl implements MovieManager{

    @Autowired
    private MovieDAO movieDAO;

    public Set<Long> getAvailableSit(Long movieId) {
        return movieDAO.getMovieById(movieId).getAvailableSit();
    }

    public Movie addMovie(String name, String description, LocalDateTime startDateTime, Set<Long> availableSit) {
        return movieDAO.add(name, description, startDateTime, availableSit);
    }
}
