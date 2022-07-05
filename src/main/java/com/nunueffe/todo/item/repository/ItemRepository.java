package com.nunueffe.todo.item.repository;

import java.util.List;

import com.nunueffe.todo.item.model.Item;

public interface ItemRepository {

	Item save(Item item);
	
	Item findById(long id);
	
	List<Item> findByBoard(long boardId);
	
}
