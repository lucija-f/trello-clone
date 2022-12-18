package com.example.trelloclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trelloclone.model.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
  
}
