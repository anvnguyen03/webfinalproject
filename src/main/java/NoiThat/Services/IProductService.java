package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.Product;

public interface IProductService {
	List<Product> findAllProduct();
	void insert(Product product);
	void update(Product product);
	void delete(int productID, int newState) throws Exception;
	List<Product> findProductByCateID(int cateid);
	List<Product> findProductByCateParensID(int cateparentsid);
	List<Product> findTop12LatestProduct();
	Product findOne(int productid);
	List<Product> findProductsByName(String productName);
	int countAll();
	List<Product> findProductByPage(int page, int pagesize);
	List<Product> findProductByCateIDPaging(int cateid, int page, int pagesize);
	List<Product> findProductByCateParensIDPaging(int cateparentsid, int page, int pagesize);
	List<Product> findProductsByNamePaging(String productName, int page, int pagesize);
}
