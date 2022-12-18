package com.example.trelloclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trelloclone.model.Board;

public interface IBoardRepository extends JpaRepository<Board, Integer> {
  
}
