package com.example.trelloclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trelloclone.model.Status;

public interface IStatusRepository extends JpaRepository<Status, Integer> {
  
}
