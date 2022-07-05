package com.nunueffe.todo.item.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nunueffe.todo.item.dto.ItemDto;
import com.nunueffe.todo.item.service.ItemService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ItemController {

	private final ItemService itemService;

	@GetMapping(value="/boards/{boardId}/items/{itemId}",produces = "application/json")
	public ResponseEntity<ItemDto> getItemById(@PathVariable long boardId,@PathVariable long itemId) {
		long userId = 10000L;			
		return ResponseEntity.status(HttpStatus.OK).body(itemService.findItemById(itemId, boardId, itemId));		
	}
	
	@GetMapping(value="/boards/{boardId}/items",produces = "application/json")
	public ResponseEntity<List<ItemDto>> getItemsByBoard(@PathVariable long boardId) {
		long userId = 10000L;

		return ResponseEntity.status(HttpStatus.OK).body(itemService.findItemsByBoard(boardId,userId));	
	}

	@PostMapping(value = "/boards/{boardId}/items", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto,
			@PathVariable long boardId) {
		
		long userId = 10000L;
		return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(itemDto,boardId,userId));
	}

//	@PutMapping(value="/boards/{boardId}/items",produces = "application/json")
//	public ResponseEntity<ItemDto> updateItem() {
//		return null;		
//	}
//	
//	@DeleteMapping(value="/boards/{boardId}/items",produces = "application/json")
//	public ResponseEntity deleteItem() {
//		return null;		
//	}
}
