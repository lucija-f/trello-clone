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

import com.example.trelloclone.model.Board;
import com.example.trelloclone.service.BoardService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BoardController {
  
  @Autowired
  private BoardService boardService;

  @GetMapping("/boards")
  public ResponseEntity<List<Board>> getAllBoards() {
    return ResponseEntity.ok().body(boardService.getAllBoards()) ;
  }

  @GetMapping("/boards/{id}")
  public ResponseEntity<Board> getBoardById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok().body(boardService.getBoardById(id));
  }

  @PostMapping("/boards")
  public ResponseEntity<Board> createBoard(@RequestBody Board board) {
    return ResponseEntity.ok().body(boardService.createBoard(board)); 
  }

  @DeleteMapping(value="/boards/{id}")
  public ResponseEntity<?> deleteBoardById(@PathVariable Integer id) {
      boardService.deleteBoard(id);
      return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
  }

  @PatchMapping(value="boards/{id}")
  public ResponseEntity<?> updateBoard(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
      return ResponseEntity.ok().body(boardService.updateBoard(id, fields));
  }
  

}
