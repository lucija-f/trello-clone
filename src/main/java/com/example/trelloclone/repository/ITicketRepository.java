package com.example.trelloclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trelloclone.model.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

  public List<Ticket> findByStatusId(Integer statusId);
  
}
