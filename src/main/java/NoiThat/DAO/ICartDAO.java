package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.Cart;

public interface ICartDAO {
	List<Cart> findAll();
	Cart findOne(int userid);
	void insert(Cart cart);
}
