package com.example.trelloclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.trelloclone.model.Board;
import com.example.trelloclone.model.Ticket;
import com.example.trelloclone.service.IBoardService;
import com.example.trelloclone.service.ITicketService;

@SpringBootApplication
public class TrelloCloneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrelloCloneApplication.class, args);
	}

	@Autowired
	IBoardService boardService;
	@Autowired
	ITicketService ticketService;

	@Override
	public void run(String... args) throws Exception {
		Board board = new Board("TestBoard");
		Ticket ticket = new Ticket("First Ticket", "First Ticket description", 1);
		boardService.createBoard(board);
		ticketService.createTicket(ticket);
	}

}
