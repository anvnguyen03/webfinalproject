package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.Product;

public interface IProductService {
	List<Product> findAllProduct();
	void insert(Product product);
	void update(Product product);
	List<Product> findProductByCateID(int cateid);
	List<Product> findProductByCateParensID(int cateparentsid);
	List<Product> findTop6LatestProduct();
	int countAll();
}
