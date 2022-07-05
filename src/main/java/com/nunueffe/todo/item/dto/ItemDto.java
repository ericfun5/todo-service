package com.nunueffe.todo.item.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String name;
		
	private ZonedDateTime dueAt;
	
	private ZonedDateTime createdAt;
	
	private ZonedDateTime modifiedAt;
}
