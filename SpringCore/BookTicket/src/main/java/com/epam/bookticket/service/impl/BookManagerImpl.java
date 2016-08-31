package com.epam.bookticket.service.impl;

import com.epam.bookticket.bean.Movie;
import com.epam.bookticket.bean.Ticket;
import com.epam.bookticket.dao.TicketDAO;
import com.epam.bookticket.service.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by Полина on 31.08.2016.
 */
@Component
public class BookManagerImpl implements BookManager {

    @Autowired
    private TicketDAO ticketDAO;

    public Long bookTicket(Movie movie, Long sitNumber) {
        Ticket ticket = ticketDAO.makeTicket(movie, sitNumber);
        return ticket.getTicketNumber();
    }

    public Boolean declineTicket(Long ticketNumber) {
        Ticket ticket = ticketDAO.getTicketById(ticketNumber);

        if (ticket.getMovie().getStartDateTime().minusHours(2).isAfter(LocalDateTime.now())) {
            ticketDAO.deleteTicket(ticket.getTicketNumber());
            return true;
        }
        return false;
    }
}
