package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import NoiThat.Entity.CartItems;
import NoiThat.JPAConfig.JPAConfig;

public class CartItemsDAOImpl implements ICartItemsDAO{

//	public static void main(String[] args) {
//		ICartItemsDAO ca = new CartItemsDAOImpl();
//		System.out.println(ca.findItemsInCart(1));
//		System.out.println(ca.findItemsInBill(1));
//		System.out.println(ca.findOne(1));
//	}
	@Override
	public List<CartItems> findItemsInCart(int cartid) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		String jpql = "SELECT c FROM CartItems c " +
//					  "WHERE c.cart.cartID = :cartid AND c.bill IS NULL";
//		TypedQuery<CartItems> query = enma.createQuery(jpql, CartItems.class);
//		query.setParameter("cartid", cartid);
//		return query.getResultList();
		
		List<CartItems> cartitems = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			String jpql = "SELECT c FROM CartItems c " +
					  "WHERE c.cart.cartID = :cartid AND c.bill IS NULL";
			TypedQuery<CartItems> query = enma.createQuery(jpql, CartItems.class);
			query.setParameter("cartid", cartid);
			
			cartitems = query.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return cartitems;
	}

	@Override
	public List<CartItems> findItemsInBill(int cartid) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		String jpql = "SELECT c FROM CartItems c " +
//					  "WHERE c.cart.cartID = :cartid AND c.bill IS NOT NULL";
//		TypedQuery<CartItems> query = enma.createQuery(jpql, CartItems.class);
//		query.setParameter("cartid", cartid);
//		return query.getResultList();
		
		List<CartItems> cartitems = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			String jpql = "SELECT c FROM CartItems c " +
					  "WHERE c.cart.cartID = :cartid AND c.bill IS NOT NULL";
			TypedQuery<CartItems> query = enma.createQuery(jpql, CartItems.class);
			query.setParameter("cartid", cartid);
			
			cartitems = query.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return cartitems;
	}

	@Override
	public CartItems findOne(int cartitemsid) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		String jpql = "SELECT c FROM CartItems c " +
//					  "WHERE c.cartItemsID = :cartitemsid";
//		TypedQuery<CartItems> query = enma.createQuery(jpql, CartItems.class);
//		query.setParameter("cartitemsid", cartitemsid);
//		try {
//	        return query.getSingleResult();
//	    } catch (NoResultException ex) {
//	        return null;
//	    }
		
		CartItems cartitem = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			String jpql = "SELECT c FROM CartItems c " +
					  "WHERE c.cartItemsID = :cartitemsid";
			TypedQuery<CartItems> query = enma.createQuery(jpql, CartItems.class);
			query.setParameter("cartitemsid", cartitemsid);
			
			cartitem = query.getSingleResult();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		try {
	        return cartitem;
	    } catch (NoResultException ex) {
	        return null;
	    }
	}

	@Override
	public void insert(CartItems cartitems) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(cartitems);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(CartItems cartitems) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(cartitems);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void delete(CartItems cartitems) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			CartItems c = enma.find(CartItems.class, cartitems.getCartItemsID());
			if (c != null) {
				enma.remove(c);
			} else {
				throw new Exception("Không tìm thấy!!");
			}
			
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
