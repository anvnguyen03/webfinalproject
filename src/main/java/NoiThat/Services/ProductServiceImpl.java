package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.IProductDAO;
import NoiThat.DAO.ProductDAOImpl;
import NoiThat.Entity.Product;

public class ProductServiceImpl implements IProductService{

	IProductDAO pro = new ProductDAOImpl();

	@Override
	public List<Product> findAllProduct() {
		return pro.findAllProduct();
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findProductByCateID(int cateid) {
		return pro.findProductByCateID(cateid);
	}

	@Override
	public List<Product> findProductByCateParensID(int cateparentsid) {
		return pro.findProductByCateParensID(cateparentsid);
	}

	@Override
	public int countAll() {
		return pro.countAll();
	}

	@Override
	public List<Product> findTop6LatestProduct() {
		return pro.findTop6LatestProduct();
	}

	@Override
	public List<Product> findProductByPage(int page, int pagesize) {
		return pro.findProductByPage(page, pagesize);
	}

	@Override
	public List<Product> findProductByCateIDPaging(int cateid, int page, int pagesize) {
		return pro.findProductByCateIDPaging(cateid, page, pagesize);
	}

	@Override
	public List<Product> findProductByCateParensIDPaging(int cateparentsid, int page, int pagesize) {
		return pro.findProductByCateParensIDPaging(cateparentsid, page, pagesize);
	}

}
