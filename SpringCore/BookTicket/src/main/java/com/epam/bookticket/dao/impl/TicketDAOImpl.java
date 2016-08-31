package com.epam.bookticket.dao.impl;

import com.epam.bookticket.bean.Movie;
import com.epam.bookticket.bean.Ticket;
import com.epam.bookticket.dao.TicketDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Полина on 31.08.2016.
 */
@Repository
public class TicketDAOImpl implements TicketDAO{

    private Map<Long, Ticket> ticketMap;
    private Long ticketSequence = 0L;

    public TicketDAOImpl() {
        ticketMap = new HashMap<Long, Ticket>();
    }

    public Ticket makeTicket(Movie movie, Long sitNumber) {
        Ticket ticket = new Ticket(ticketSequence++, sitNumber, movie);
        ticketMap.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }

    public void deleteTicket(Long ticketNumber) {
        ticketMap.remove(ticketNumber);
    }

    public Ticket getTicketById(Long ticketNumber) {
        return ticketMap.get(ticketNumber);
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<Ticket>(ticketMap.values());
    }
}
