package com.jdental.service.ServiceImpl;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdental.dao.CartDao;
import com.jdental.dao.CartItemDao;
import com.jdental.dao.ItemDao;
import com.jdental.dao.RoleDao;
import com.jdental.dao.UserDao;
import com.jdental.domain.Cart;
import com.jdental.domain.CartItem;
import com.jdental.domain.Item;
import com.jdental.domain.User;
import com.jdental.domain.security.UserRole;
import com.jdental.service.CartItemService;
import com.jdental.service.CartService;
import com.jdental.service.UserService;

@Service
public class CartServiceImpl implements CartService{
	private  static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

	@Autowired
    private CartDao cartDao;
	@Autowired
    private CartItemDao cartItemDao;
    
	@Autowired
    private CartItemService cartItemService;
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private UserService userService;
    
    public Cart updateCart(Cart cart) {
        BigDecimal total = new BigDecimal(0);

        List<CartItem> cartItemList = cartItemService.findByCart(cart);

        for (CartItem cartItem: cartItemList) {
            if (cartItem.getItem().getQuantity() > 0 ) {
                cartItemService.updateCartItem(cartItem);
                total = total.add(cartItem.getSubTotal());
            }
        }
        cart.setGrandTotal(total);
        cartDao.save(cart);
        return cart;
    }

    ///last try

	@Override
	public Cart findByUser(User user) {
        return cartDao.findByUser(user);
    }  
    @Override
	public Cart findCartByUsername(String username) {
        User user = userService.findByUsername(username);
        return cartDao.findByUser(user);
    }  


    // @Override
    // public void removeCart(Cart cart) {

	// 	cartDao.delete(cart);
    // }

    // @Override
    // public List<Cart> getCart() {
    //     return cartDao.findAll();
    // }


}
