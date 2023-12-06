package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.CartDAOImpl;
import NoiThat.DAO.ICartDAO;
import NoiThat.Entity.Cart;

public class CartServiceImpl implements ICartService{
	
	ICartDAO cartService = new CartDAOImpl();
	@Override
	public List<Cart> findAll() {
		return cartService.findAll();
	}

	@Override
	public Cart findOne(int userid) {
		return cartService.findOne(userid);
	}

	@Override
	public void insert(Cart cart) {
		cartService.insert(cart);
	}
	

}
