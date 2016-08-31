package com.epam.bookticket.service;

import com.epam.bookticket.bean.Movie;

/**
 * Created by Полина on 31.08.2016.
 */

public interface BookManager {

    Long bookTicket(Movie movie, Long sitNumber);

    Boolean declineTicket(Long ticketNumber);
}
