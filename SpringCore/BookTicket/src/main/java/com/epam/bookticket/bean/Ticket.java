package com.epam.bookticket.bean;

/**
 * Created by Полина on 31.08.2016.
 */
public class Ticket {
    private Long sitNumber;
    private Movie movie;
    private Long ticketNumber;

    public Ticket(Long ticketNumber, Long sitNumber, Movie movie) {
        this.sitNumber = sitNumber;
        this.movie = movie;
        this.ticketNumber = ticketNumber;
    }

    public Long getSitNumber() {

        return sitNumber;
    }

    public void setSitNumber(Long sitNumber) {
        this.sitNumber = sitNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }
}
