package com.nunueffe.todo.item.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nunueffe.todo.item.enums.ItemStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity {

	@Id
	private long id;

	private String name;

	private long boardId;

	private String status;
	
	private ZonedDateTime dueAt;
	
	private ZonedDateTime createdAt;

	private ZonedDateTime modifiedAt;

}
