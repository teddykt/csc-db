package com.jdental.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdental.dao.ItemDao;
import com.jdental.dao.RoleDao;
import com.jdental.dao.UserDao;
import com.jdental.domain.Item;
import com.jdental.domain.security.UserRole;
import com.jdental.service.UserService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	private static final Logger LOG = LoggerFactory.getLogger(ItemService.class);
	

	@Autowired
	private ItemDao itemDao;
	
	public void save(Item item) {
		itemDao.save(item);
	}
	
	public Item findByName(String name) {
		return itemDao.findByName(name);
	}

    public boolean checkItemExists(String name) {
        if (null != findByName(name)) {
            return true;
        }

        return false;
    }
	

	 public Item addItem(Item item) {
        Item localItem = itemDao.findByName(item.getName());
            localItem = itemDao.save(item);

        return localItem;
    }

	 
	 public List<Item> findItemList() {
		 return itemDao.findAll();
	 }
	 
	
}
