package com.jdental.service;

import java.util.List;
import java.util.Set;

import com.jdental.domain.User;
import com.jdental.domain.security.UserRole;

public interface UserService {
	User findByUsername(String username);
	
	User findByEmail(String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
	
	boolean checkUserExists(String username, String email);
	
	User createUser(User user, Set<UserRole> userRoles);

    void save (User user);
    
    User saveUser (User user);
    
    List<User> findUserList();
    
    // void enableUser (String username);
    
    // void disableUser(String username);

    // User getUser(String username);
    
}
