package com.nunueffe.todo.item.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nunueffe.todo.item.dataaccess.repository.ItemJpaRepository;
import com.nunueffe.todo.item.entity.ItemEntity;
import com.nunueffe.todo.item.exception.ItemNotFoundException;
import com.nunueffe.todo.item.mapper.ItemDataAccessMapper;
import com.nunueffe.todo.item.model.Item;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

	private final ItemJpaRepository itemJpaRepository;

	@Override
	public Item save(Item item) {
		return ItemDataAccessMapper
				.itemEntityToItem(itemJpaRepository.save(ItemDataAccessMapper.itemToItemEntity(item)));

	}

	@Override
	public Item findById(long id) {
		return ItemDataAccessMapper.itemEntityToItem(itemJpaRepository.findById(id).orElseThrow(
				() -> new ItemNotFoundException(String.format("itemId= %s not found", id))));

	}

	@Override
	public List<Item> findByBoard(long boardId) {
		return itemJpaRepository.findByBoardId(boardId).stream()
		.map(ItemDataAccessMapper::itemEntityToItem)
		.collect(Collectors.toList());			
	}

}
