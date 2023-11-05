package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.Product;

public interface IProductService {
	List<Product> findAllProduct();
	void insert(Product product);
	void update(Product product);
	List<Product> findProductByCateName(String catename);
	int countAll();
}
