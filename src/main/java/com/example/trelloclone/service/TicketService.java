package com.example.trelloclone.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
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
  public Ticket updateTicket(Integer id, Map<String, Object> fields) {
    Optional<Ticket> ticketData = this.ticketRepository.findById(id);
    if (ticketData.isPresent()) {
      Ticket updatedTicket = ticketData.get();
      // Map key is field name, v is value
      fields.forEach((k, v) -> {
        // use reflection to get field k on ticket and set it to value v
        Field field = ReflectionUtils.findRequiredField(Ticket.class, k);
        field.setAccessible(true);
        ReflectionUtils.setField(field, updatedTicket, v);
      });
      this.ticketRepository.save(updatedTicket);
      return updatedTicket;
    }else {
      throw new NotFoundException("Ticket not found!");
    }
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
