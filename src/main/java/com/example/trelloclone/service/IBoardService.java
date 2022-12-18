package com.example.trelloclone.service;

import java.util.List;

import com.example.trelloclone.model.Board;

public interface IBoardService {
  Board createBoard(Board board);

  Board updateBoard(Board board);

  Board getBoardById(Integer id);

  List<Board> getAllBoards();

  void deleteBoard(Integer id);
  
}
