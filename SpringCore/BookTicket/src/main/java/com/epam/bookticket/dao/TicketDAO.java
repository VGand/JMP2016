package com.epam.bookticket.dao;

import com.epam.bookticket.bean.Movie;
import com.epam.bookticket.bean.Ticket;

import java.util.List;

/**
 * Created by Полина on 31.08.2016.
 */
public interface TicketDAO {
    Ticket makeTicket(Movie movie, Long sitNumber);
    void deleteTicket(Long ticketNumber);
    Ticket getTicketById(Long ticketNumber);
    List<Ticket> getAllTickets();

}
