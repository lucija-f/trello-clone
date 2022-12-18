package com.example.trelloclone.service;

import java.util.List;

import com.example.trelloclone.model.Ticket;

public interface ITicketService {
  Ticket createTicket(Ticket ticket);

  Ticket updateTicket(Ticket ticket);

  Ticket getTicketById(Integer id);

  List<Ticket> getAllTickets();

  void deleteTicket(Integer id);
}
