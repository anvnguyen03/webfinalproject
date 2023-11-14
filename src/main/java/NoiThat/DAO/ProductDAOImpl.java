package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import NoiThat.Entity.Category;
import NoiThat.Entity.Product;
import NoiThat.JPAConfig.JPAConfig;

public class ProductDAOImpl implements IProductDAO{

//	 public static void main(String[] args) {
//			IProductDAO pro = new ProductDAOImpl();
////			System.out.println(pro.countAll());
////			System.out.println(pro.findAllProduct());
////			System.out.println(pro.findProductByCateID(1));
//			System.out.println(pro.findTop6LatestProduct());
////			System.out.println(pro.findProductByCateParensID(1));
//		}
	
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
	public int countAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM Product c";
		javax.persistence.Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}

	@Override
	public List<Product> findProductByCateID(int cateid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p " +
					  "WHERE p.category.cateID = :cateid";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		query.setParameter("cateid", cateid);
		return query.getResultList();
	}

	@Override
	public List<Product> findProductByCateParensID(int cateparentsid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p " +
					  "JOIN p.category c " +
					  "JOIN c.cateParent cp " +
					  "WHERE cp.cateParentsID = :cateParentsID";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		query.setParameter("cateParentsID", cateparentsid);
		return query.getResultList();
	}

	@Override
	public List<Product> findTop6LatestProduct() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p " +
					  "ORDER BY p.productID " +
					  "DESC";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		query.setMaxResults(6);
		return query.getResultList();
	}

}
