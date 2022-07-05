package com.nunueffe.todo.board.exception;

public class UserNotAllowedException extends RuntimeException{
	public UserNotAllowedException(String message) {
        super(message);
    }
}
