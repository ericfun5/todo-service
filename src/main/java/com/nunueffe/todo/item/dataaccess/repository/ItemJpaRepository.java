package com.nunueffe.todo.item.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nunueffe.todo.item.entity.ItemEntity;

@Repository
public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long>{

//	public Optional<ItemEntity> findByIdAndBoardId(long id , long boardId);
	
	public List<ItemEntity> findByBoardId(long boardId);
}
