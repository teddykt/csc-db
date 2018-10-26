package com.jdental.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import com.jdental.dao.CartItemDao;
import com.jdental.domain.Cart;
import com.jdental.domain.CartItem;
import com.jdental.service.CartItemService;
 
@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemDao cartItemDao;

    public List<CartItem> findByCart(Cart cart) {
        return cartItemDao.findByCart(cart);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(1);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubTotal(bigDecimal);
        cartItemDao.save(cartItem);

        return cartItem;
    }

    public CartItem addToCart(CartItem cartItem) {
        return cartItemDao.save(cartItem);

        // CartItem target = new CartItem(); 
        // target = cartItem;
        // return cartItemDao.save(target);
    }

        public void deleteById(Long id) {
            cartItemDao.deleteById(id);
        }
}