package com.jdental.service.ServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdental.dao.CartDao;
import com.jdental.dao.RoleDao;
import com.jdental.dao.UserDao;
import com.jdental.domain.Cart;
import com.jdental.domain.User;
import com.jdental.domain.security.Role;
import com.jdental.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	

	@Autowired
	private UserDao userDao;
	
	@Autowired
    private RoleDao roleDao; 
    
	@Autowired
    private CartDao cartDao;  

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
	
	public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }
    
    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }
	

    @Override
    @Transactional
    public User createUser(User user) {
        User localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            Role role = roleDao.findByName("USER");
            List<Role> roles = Arrays.asList(role);
            user.setRoles(roles);

            Cart cart = new Cart();
            BigDecimal total = new BigDecimal(0.00);
            cart.setGrandTotal(total);
            cart.setUser(user);
            cartDao.save(cart);
            localUser = userDao.save(user);
        }

        return localUser;
    }

	 public User saveUser (User user) {
		 return userDao.save(user);
	 }
    //  public User getUser (String username) {
    //     return userDao.findByUsername(username);
    // }
    
	 public List<User> findUserList() {
		 return userDao.findAll();
    }
	 
	//  public void enableUser(String username) {
	// 	 User user = findByUsername(username);
	// 	 user.setEnabled(true);
	// 	 userDao.save(user);
	//  }
	 
	 
	//  public void disableUser (String username) {
	// 	 User user = findByUsername(username);
	// 	 user.setEnabled(false);
	// 	 System.out.println(user.isEnabled());
	// 	 userDao.save(user);
	// 	 System.out.println(username + " is disabled.");
	//  }
	
}
