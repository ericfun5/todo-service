package com.nunueffe.todo.board.service;

import org.springframework.stereotype.Service;

import com.nunueffe.todo.board.service.model.Board;

@Service
public class BoardService {

	public Board findById(long boardId) {
		return new Board();
	}
}
