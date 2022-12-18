package com.example.trelloclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.trelloclone.model.Board;
import com.example.trelloclone.service.IBoardService;

@SpringBootApplication
public class TrelloCloneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrelloCloneApplication.class, args);
	}

	@Autowired
	IBoardService boardService;

	@Override
	public void run(String... args) throws Exception {
		Board board = new Board("TestBoard");
		boardService.createBoard(board);
		
	}

}
