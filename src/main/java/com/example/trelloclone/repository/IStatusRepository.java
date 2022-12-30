package com.example.trelloclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trelloclone.model.Status;

public interface IStatusRepository extends JpaRepository<Status, Integer> {

  public List<Status> findByBoardId(Integer boardId);
  
}
