package com.nunueffe.todo.board.service.model;

public class Board {

	private long id;
	private long userId;
	
	public boolean isAllowed(long userId) {
		
		return true;
	}
}
