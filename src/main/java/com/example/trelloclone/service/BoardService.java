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
import com.example.trelloclone.model.Board;
import com.example.trelloclone.repository.IBoardRepository;


@Service
@Transactional
public class BoardService implements IBoardService {

  @Autowired
  private IBoardRepository boardRepository;

  @Override
  public Board createBoard(Board board) {
    return this.boardRepository.save(board);
  }

  @Override
  public Board updateBoard(Integer id, Map<String, Object> fields) {
    Optional<Board> boardData = this.boardRepository.findById(id);
    if (boardData.isPresent()){
      Board updatedBoard = boardData.get();
      fields.forEach((k, v) -> {
        Field field = ReflectionUtils.findRequiredField(Board.class, k);
        field.setAccessible(true);
        ReflectionUtils.setField(field, updatedBoard, v);
      });
      this.boardRepository.save(updatedBoard);
      return updatedBoard;
    } else {
      throw new NotFoundException("Board not found!");
    }
  }

  @Override
  public List<Board> getAllBoards() {
    return this.boardRepository.findAll();
  }

  @Override
  public void deleteBoard(Integer id) {
    Optional<Board> boardData = this.boardRepository.findById(id);
    if (boardData.isPresent()){
      this.boardRepository.delete(boardData.get());
    }else {
      throw new NotFoundException("Board not found!");
    }
  }

  @Override
  public Board getBoardById(Integer id) {
    Optional<Board> boardDb = this.boardRepository.findById(id);
    if (boardDb.isPresent()){
      return boardDb.get();
    } else {
      throw new NotFoundException("Board not found!");
    }
  }

}
