package com.javatechie.crud.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.example.entity.Tickets;
import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.service.TicketService;
import com.javatechie.crud.example.service.UserService;

@RestController
public class TicketController {

    @Autowired
    TicketService service;


    @Autowired
    UserService userService;

    @PostMapping("/addTicket")
    public Tickets addUser(@RequestBody Tickets ticket) {
        User user = userService.getUsersById(1L);
        // User user2 = userService.getUsersById(1);
        ticket.setUser(userService.getUsersById(1L));
        return service.saveTicket(ticket);
    }
}
