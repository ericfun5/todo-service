package com.nunueffe.todo.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nunueffe.todo.board.exception.UserNotAllowedException;
import com.nunueffe.todo.board.service.BoardService;
import com.nunueffe.todo.board.service.model.Board;
import com.nunueffe.todo.item.dto.ItemDto;
import com.nunueffe.todo.item.exception.ItemNotFoundException;
import com.nunueffe.todo.item.mapper.ItemDataMapper;
import com.nunueffe.todo.item.model.Item;
import com.nunueffe.todo.item.repository.ItemRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

	private final BoardService boardService;
	private final ItemRepository itemRepository;

//	@Cacheable(value = "todo#item", key = "#id")
	@Transactional(readOnly=true)
	public ItemDto findItemById(long itemId, long boardId, long userId) {
		log.info("query id = {} ", itemId);
		
		Board board = boardService.findById(boardId);
		if (!board.isAllowed(userId)) {
			throw new UserNotAllowedException(
					String.format("UserId=%s is not allowed to use board=%s", userId, boardId));
		}
		
		Item item = itemRepository.findById(itemId);
		item.validateOwner(boardId);	
		
		ItemDto res = ItemDataMapper.ItemToItemDto(item);
		return res;
	}

//	@Cacheable(value="todo#item",key="#id")
	public List<ItemDto> findItemsByBoard(long boardId,long userId) {
		
		Board board = boardService.findById(boardId);
		if (!board.isAllowed(userId)) {
			throw new UserNotAllowedException(
					String.format("UserId=%s is not allowed to use board=%s", userId, boardId));
		}
		
		List<Item> items = itemRepository.findByBoard(boardId);
		return items.stream().map(ItemDataMapper::ItemToItemDto).collect(Collectors.toList());
					
	}

//	@CachePut(value = "todo#item", key = "#result.id")
	@Transactional
	public ItemDto createItem(ItemDto itemDto, long boardId, long userId) {

		// validate boardId
		Board board = boardService.findById(boardId);

		if (!board.isAllowed(userId)) {
			throw new UserNotAllowedException(
					String.format("UserId=%s is not allowed to use board=%s", userId, boardId));
		}

		Item item = Item.builder().name(itemDto.getName()).boardId(boardId).dueAt(itemDto.getDueAt())
				.build();

		item.initializeItem();
		item.validateItem();

		item = itemRepository.save(item);

		ItemDto res = ItemDataMapper.ItemToItemDto(item);

		return res;

	}

//	@CachePut(value = "todo#item", key = "#result.id")
//	public ItemDto updateItem(ItemDto itemDto) {
//		return null;
//	}
//
//	@CacheEvict(value = "todo#item", key = "#id")
//	public void deleteItem(String id) {
//
//	}
}
