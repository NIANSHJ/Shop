package service;

import dao.CartDao;
import model.Cart;
import java.sql.SQLException;
import java.util.List;


//向视图层提供购物车相关服务
public class CartService {

    private CartDao cartDao=new CartDao();

    public void addCart(Cart cart) {
        try {
            cartDao.addCart(cart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cart> selectCart(long id){
        List<Cart> list = null;
        try {
            list = cartDao.selectCart(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Cart selectCart(long id, long uid) {
        Cart cart = null;
        try {
            cart = cartDao.selectCart(id, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    public Cart selectCartItem(long id) {
        Cart cart = null;
        try {
            cart = cartDao.selectCartItem(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    public void updateCart(long id, int count) {
        try {
            cartDao.updateCart(id, count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int countCart(long id) {
        int num = 0;
        try {
            num = cartDao.countCart(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public void deleteCart(long id) {
        try {
            cartDao.deleteCart(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
