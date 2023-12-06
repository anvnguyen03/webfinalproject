package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import NoiThat.Entity.Cart;
import NoiThat.JPAConfig.JPAConfig;

public class CartDAOImpl implements ICartDAO{
	
	
//	  public static void main(String[] args) { 
//		  ICartDAO cartService = new CartDAOImpl();
////		  System.out.println(cartService.findOne(1)); 
//		  User user = new User();
//		  user.setUserID(10);
//		  Cart cart = new Cart();
//		  cart.setUser(user);
//		  cartService.insert(cart);
//	  }
	 

	@Override
	public List<Cart> findAll() {
//		EntityManager enma = JPAConfig.getEntityManager();
//		TypedQuery<Cart> query = enma.createNamedQuery("Cart.findAll", Cart.class);
//		return query.getResultList();
		
		List<Cart> carts = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			TypedQuery<Cart> query = enma.createNamedQuery("Cart.findAll", Cart.class);
			
			carts = query.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return carts;
	}

	@Override
	public Cart findOne(int userid) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		String jpql = "SELECT c FROM Cart c " +
//				  	  "WHERE c.user.userID = :userid";
//		TypedQuery<Cart> query = enma.createQuery(jpql, Cart.class);
//		query.setParameter("userid", userid);
//		return query.getSingleResult();
		
		Cart cart = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			String jpql = "SELECT c FROM Cart c " +
				  	  "WHERE c.user.userID = :userid";
		TypedQuery<Cart> query = enma.createQuery(jpql, Cart.class);
		query.setParameter("userid", userid);
			
			cart = query.getSingleResult();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return cart;
	}

	@Override
	public void insert(Cart cart) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(cart);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

}
