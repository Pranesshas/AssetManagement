package com.javatechie.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.crud.example.entity.Tickets;

public interface TicketRepository extends JpaRepository<Tickets,Long> {
    
}
