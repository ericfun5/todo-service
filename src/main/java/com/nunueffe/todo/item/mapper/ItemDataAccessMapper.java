package com.nunueffe.todo.item.mapper;

import com.nunueffe.todo.item.entity.ItemEntity;
import com.nunueffe.todo.item.enums.ItemStatus;
import com.nunueffe.todo.item.model.Item;

public class ItemDataAccessMapper {

	public static ItemEntity itemToItemEntity(Item item) {
		
		ItemEntity itemEntity = ItemEntity.builder()
				.id(item.getId())
				.boardId(item.getBoardId())
				.name(item.getName())
				.status(item.getStatus().toString())
				.dueAt(item.getDueAt())
				.createdAt(item.getCreatedAt())
				.modifiedAt(item.getModifiedAt())
				.build();
				
		return itemEntity;	
	}
	
	public static Item itemEntityToItem(ItemEntity entity) {
		
		Item item = Item.builder()
				.id(entity.getId())
				.boardId(entity.getBoardId())
				.name(entity.getName())				
				.status(ItemStatus.valueOf(entity.getStatus()))
				.dueAt(entity.getDueAt())
				.createdAt(entity.getCreatedAt())
				.modifiedAt(entity.getModifiedAt())
				.build();
				
		return item;	
	}
}
