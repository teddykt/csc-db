package com.jdental.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jdental.domain.Item;
import com.jdental.domain.User;

public interface ItemDao extends CrudRepository<Item, Long> {
	Item findByName(String name);
    List<Item> findAll();
}
