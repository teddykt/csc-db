package com.jdental.service;

import java.util.List;

import com.jdental.domain.Item;

public interface ItemService {

    void save(Item item);
	
    Item findByName(String name);
    
	
    boolean checkItemExists(String name);

    Item addItem(Item item);

    List<Item> findItemList();

}
