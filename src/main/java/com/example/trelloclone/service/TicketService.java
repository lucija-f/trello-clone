package com.example.trelloclone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trelloclone.exception.NotFoundException;
import com.example.trelloclone.model.Ticket;
import com.example.trelloclone.repository.ITicketRepository;

@Service
@Transactional
public class TicketService implements ITicketService {

  @Autowired
  private ITicketRepository ticketRepository;

  @Override
  public Ticket createTicket(Ticket ticket) {
    return this.ticketRepository.save(ticket);
  }

  @Override
  public Ticket updateTicket(Ticket ticket) {
    Optional<Ticket> ticketData = this.ticketRepository.findById(ticket.getId());
    if (ticketData.isPresent()) {
      Ticket updatedTicket = ticketData.get();
      updatedTicket.setId(ticket.getId());
      updatedTicket.setTitle(ticket.getTitle());
      updatedTicket.setDescription(ticket.getDescription());
      updatedTicket.setStatusId(ticket.getStatusId());
      this.ticketRepository.save(updatedTicket);
    }
    return null;
  }

  @Override
  public Ticket getTicketById(Integer id) {
    Optional<Ticket> ticketData = this.ticketRepository.findById(id);
    if (ticketData.isPresent()) {
      return ticketData.get();
    }else {
      throw new NotFoundException("Ticket not found.");
    }
    
  }

  @Override
  public List<Ticket> getAllTickets() {
    return this.ticketRepository.findAll();
  }

  @Override
  public void deleteTicket(Integer id) {
    Optional<Ticket> ticketData = this.ticketRepository.findById(id);
    if (ticketData.isPresent()) {
      this.ticketRepository.delete(ticketData.get());
    }else {
      throw new NotFoundException("Ticket not found.");
    }
    
  }
  
}
