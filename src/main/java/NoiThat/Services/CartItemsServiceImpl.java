package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.CartItemsDAOImpl;
import NoiThat.DAO.ICartItemsDAO;
import NoiThat.Entity.CartItems;

public class CartItemsServiceImpl implements ICartItemsService{

	ICartItemsDAO cart = new CartItemsDAOImpl();
	@Override
	public List<CartItems> findItemsInCart(int cartid) {
		return cart.findItemsInCart(cartid);
	}

	@Override
	public List<CartItems> findItemsInBill(int cartid) {
		return cart.findItemsInBill(cartid);
	}


	@Override
	public void insert(CartItems cartitems) {
		cart.insert(cartitems);
	}

	@Override
	public void update(CartItems cartitems) {
		cart.update(cartitems);
	}

	@Override
	public void delete(CartItems cartitems) throws Exception {
		cart.delete(cartitems);
	}

	@Override
	public CartItems findOne(int cartitemsid) {
		return cart.findOne(cartitemsid);
	}

}
