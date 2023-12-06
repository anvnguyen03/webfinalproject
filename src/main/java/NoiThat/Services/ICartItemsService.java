package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.CartItems;

public interface ICartItemsService {
	List<CartItems> findItemsInCart(int cartid);
	List<CartItems> findItemsInBill(int cartid);
	CartItems findOne(int cartitemsid);
	void insert(CartItems cartitems);
	void update(CartItems cartitems);
	void delete(CartItems cartitems) throws Exception;
}
