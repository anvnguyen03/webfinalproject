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
	public List<Product> findProductByCateName(String catename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		return pro.countAll();
	}

}
