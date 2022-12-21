package com.example.trelloclone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trelloclone.model.Ticket;
import com.example.trelloclone.service.TicketService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TicketController {
  
  @Autowired
  private TicketService ticketService;

  @GetMapping("/tickets")
  public ResponseEntity<List<Ticket>> getAllTickets() {
    return ResponseEntity.ok().body(ticketService.getAllTickets());
  }

  @GetMapping("/tickets/{id}")
  public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok().body(ticketService.getTicketById(id));
  }

  @PostMapping("/tickets")
  public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
    return ResponseEntity.ok().body(ticketService.createTicket(ticket)); 
  }

  @PatchMapping("tickets/{id}")
  public ResponseEntity<Ticket> updateTicket(@PathVariable("id") Integer id, @RequestBody Map<String, Object> fields) {
    return ResponseEntity.ok().body(ticketService.updateTicket(id, fields));
  }

  @DeleteMapping("tickets/{id}")
  public ResponseEntity<?> deleteTicketById(@PathVariable("id") Integer id) {
    ticketService.deleteTicket(id);
    return ResponseEntity.ok().body(HttpStatus.OK);
  }

}
