package com.example.trelloclone.service;

import java.util.List;
import java.util.Map;

import com.example.trelloclone.model.Ticket;

public interface ITicketService {
  Ticket createTicket(Ticket ticket);

  Ticket updateTicket(Integer id, Map<String, Object> fields);

  Ticket getTicketById(Integer id);

  List<Ticket> getAllTickets();

  List<Ticket> getAllTicketsByStatusId(Integer statusId);

  void deleteTicket(Integer id);

  void deleteTicketsByStatusId(Integer statusId);
}
