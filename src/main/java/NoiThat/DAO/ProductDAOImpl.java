package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import NoiThat.Entity.Product;
import NoiThat.JPAConfig.JPAConfig;

public class ProductDAOImpl implements IProductDAO{

	@Override
	public List<Product> findAllProduct() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);
		return query.getResultList();
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
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM Product c";
		javax.persistence.Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}
	 public static void main(String[] args) {
		IProductDAO pro = new ProductDAOImpl();
		System.out.println(pro.countAll());
		System.out.println(pro.findAllProduct());
	}

}
