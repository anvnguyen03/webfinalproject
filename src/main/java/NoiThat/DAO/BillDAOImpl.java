package NoiThat.DAO;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import NoiThat.Entity.Bill;
import NoiThat.JPAConfig.JPAConfig;

public class BillDAOImpl implements IBillDAO{
	
	@Override
	public List<Bill> findAll() {
//		EntityManager enma = JPAConfig.getEntityManager();
//		TypedQuery<Bill> query = enma.createNamedQuery("Bill.findAll", Bill.class);
//		return query.getResultList();
		List<Bill> bills = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			TypedQuery<Bill> query = enma.createNamedQuery("Bill.findAll", Bill.class);
			
			bills = query.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return bills;
	}

	@Override
	public List<Bill> findByID(int billid) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		String jpql = "SELECT b FROM Bill b " +
//				  	  "WHERE b.billID = :billid";
//		TypedQuery<Bill> query = enma.createQuery(jpql, Bill.class);
//		query.setParameter("billid", billid);
//		return query.getResultList();
		
		List<Bill> bills = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			String jpql = "SELECT b FROM Bill b " +
				  	  "WHERE b.billID = :billid";
			TypedQuery<Bill> query = enma.createQuery(jpql, Bill.class);
			query.setParameter("billid", billid);
			
			bills = query.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return bills;
		
	}

	@Override
	public List<Bill> findByUser(int userid) {
//		EntityManager enma = JPAConfig.getEntityManager();
//		String jpql = "SELECT b FROM Bill b " +
//				  	  "WHERE b.user.userID = :userid";
//		TypedQuery<Bill> query = enma.createQuery(jpql, Bill.class);
//		query.setParameter("userid", userid);
//		return query.getResultList();
		
		List<Bill> bills = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			String jpql = "SELECT b FROM Bill b " +
				  	  "WHERE b.user.userID = :userid";
			TypedQuery<Bill> query = enma.createQuery(jpql, Bill.class);
			query.setParameter("userid", userid);
			
			bills = query.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return bills;
	}

	@Override
	public void insert(Bill bill) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			long currentTimeMillis = System.currentTimeMillis();
			Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
			bill.setCreatedAt(currentTimestamp);
			
			enma.persist(bill);
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
	public void update(Bill bill) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(bill);
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
