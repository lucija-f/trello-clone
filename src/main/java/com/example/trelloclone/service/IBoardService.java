package com.example.trelloclone.service;

import java.util.List;
import java.util.Map;

import com.example.trelloclone.model.Board;

public interface IBoardService {
  Board createBoard(Board board);

  Board updateBoard(Integer id, Map<String, Object> fields);

  Board getBoardById(Integer id);

  List<Board> getAllBoards();

  void deleteBoard(Integer id);
  
}
