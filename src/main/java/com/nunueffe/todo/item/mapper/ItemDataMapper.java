package com.nunueffe.todo.item.mapper;

import com.nunueffe.todo.item.dto.ItemDto;
import com.nunueffe.todo.item.entity.ItemEntity;
import com.nunueffe.todo.item.model.Item;

public class ItemDataMapper {

	public static ItemDto ItemToItemDto(Item item) {
		ItemDto res = ItemDto.builder()
				.id(item.getId())
				.name(item.getName())
				.createdAt(item.getCreatedAt())
				.dueAt(item.getDueAt())
				.build();
		return res;
	}
	
	
	public static ItemDto ItemEntityToItemDto(ItemEntity entity) {
		ItemDto res = ItemDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.createdAt(entity.getCreatedAt())
				.dueAt(entity.getDueAt())
				.createdAt(entity.getCreatedAt())
				.modifiedAt(entity.getModifiedAt())
				.build();
		return res;
	}
}
