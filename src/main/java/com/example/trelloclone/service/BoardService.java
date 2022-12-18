package com.example.trelloclone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
  public Board updateBoard(Board board) {
    Optional<Board> boardDb = this.boardRepository.findById(board.getId());
    if (boardDb.isPresent()){
      Board updateBoard = boardDb.get();
      updateBoard.setId(board.getId());
      updateBoard.setName(board.getName());
      this.boardRepository.save(updateBoard);
      return updateBoard;
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
    Optional<Board> boardDb = this.boardRepository.findById(id);
    if (boardDb.isPresent()){
      this.boardRepository.delete(boardDb.get());
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
