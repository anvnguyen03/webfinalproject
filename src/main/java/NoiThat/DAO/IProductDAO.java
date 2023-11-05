package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.Category;
import NoiThat.Entity.Product;

public interface IProductDAO {
	List<Product> findAllProduct();
	void insert(Product product);
	void update(Product product);
	List<Product> findProductByCateName(String catename);
	int countAll();
}
