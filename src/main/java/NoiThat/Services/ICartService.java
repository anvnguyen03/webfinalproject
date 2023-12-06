package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.Cart;

public interface ICartService {
	List<Cart> findAll();
	Cart findOne(int userid);
	void insert(Cart cart);
}
