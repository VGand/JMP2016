package com.epam.bookticket.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Полина on 31.08.2016.
 */
public class Movie {

    private String name;
    private Long id;
    private String description;
    private LocalDateTime startDateTime;
    private Set<Long> availableSit;

    public Movie(String name, Long id, String description, LocalDateTime startDateTime, Set<Long> availableSit) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.startDateTime = startDateTime;
        this.availableSit = availableSit;
    }

    public Movie(String name, Long id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Set<Long> getAvailableSit() {
        return availableSit;
    }

    public void setAvailableSit(Set<Long> availableSit) {
        this.availableSit = availableSit;
    }
}
