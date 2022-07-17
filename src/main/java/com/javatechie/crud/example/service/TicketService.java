package com.javatechie.crud.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Tickets;
import com.javatechie.crud.example.repository.TicketRepository;

@Service
public class TicketService {
    
    @Autowired
    TicketRepository ticketRepo;

    public Tickets saveTicket(Tickets ticket) {
        return ticketRepo.save(ticket);
    }

}
