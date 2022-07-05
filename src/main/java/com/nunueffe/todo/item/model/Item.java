package com.nunueffe.todo.item.model;

import java.time.ZonedDateTime;

import com.nunueffe.todo.item.enums.ItemStatus;
import com.nunueffe.todo.item.exception.ItemDomainException;

public class Item {
	
	private long id;
	private ItemStatus status;
	private ZonedDateTime createdAt;
	private ZonedDateTime modifiedAt;

	private final String name;
	private final long boardId;
	private final ZonedDateTime dueAt;

	private Item(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.boardId = builder.boardId;
		this.status = builder.status;
		this.dueAt = builder.dueAt;
		this.createdAt = builder.createdAt;
		this.modifiedAt = builder.modifiedAt;
	}

	public void initializeItem() {
		this.id = System.currentTimeMillis();
		this.status = ItemStatus.OPEN;
		this.createdAt = ZonedDateTime.now();
	}

	
	public void validateOwner(long boardId) {
		if(this.boardId != boardId) {
			throw new ItemDomainException("Item status is not belong to "+boardId);
		}
	}
	
	public void finish() {
		if(this.status == null || 
				(this.status != ItemStatus.OPEN && this.status != ItemStatus.DONE)) {
			throw new ItemDomainException("Item status is not valid ");
		} 
	}
	
	public void validateItem() {

		if (this.id <= 0) {
			throw new ItemDomainException("ItemId should be initialized ");
		}

		if (this.boardId <= 0) {
			throw new ItemDomainException("BoardId should be initialized ");
		}

		if (this.name == null && this.name.trim().isBlank()) {
			throw new ItemDomainException("Item name can not be blank");
		}

		if (this.status == null || this.status != ItemStatus.OPEN) {
			throw new ItemDomainException("ItemStatus need to be OPEN but it is : " + this.status);
		}

		if (this.dueAt != null && ZonedDateTime.now().isAfter(this.dueAt)) {
			throw new ItemDomainException("Due date need to be after current date");
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private long id;
		private String name;
		private long boardId;
		private ItemStatus status;
		private ZonedDateTime dueAt;
		private ZonedDateTime createdAt;
		private ZonedDateTime modifiedAt;

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder boardId(long boardId) {
			this.boardId = boardId;
			return this;
		}

		public Builder status(ItemStatus status) {
			this.status = status;
			return this;
		}

		public Builder dueAt(ZonedDateTime dueAt) {
			this.dueAt = dueAt;
			return this;
		}
		
		public Builder createdAt(ZonedDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		
		public Builder modifiedAt(ZonedDateTime modifiedAt) {
			this.modifiedAt = modifiedAt;
			return this;
		}

		public Item build() {
			return new Item(this);
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public long getBoardId() {
		return boardId;
	}

	public ZonedDateTime getDueAt() {
		return dueAt;
	}
	
	public ZonedDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(ZonedDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
