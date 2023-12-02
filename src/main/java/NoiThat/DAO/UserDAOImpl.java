package NoiThat.DAO;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import NoiThat.Entity.Category;
import NoiThat.Entity.User;
import NoiThat.JPAConfig.JPAConfig;

public class UserDAOImpl implements IUserDAO{

//	public static void main(String[] args) throws Exception {
//		IUserDAO user = new UserDAOImpl();
////		System.out.println(user.findOne("admin"));
////		System.out.println(user.findOne(1));
////		System.out.println(user.findAllUser());
//		
//		User u1 = new User();
//		u1.setUsername("test_01");
//		u1.setPassword("99999dawd");
//		u1.setEmail("test@gmail.com");
//		u1.setCode("123456");
//		u1.setState(0);
//		u1.setFullname("tôi tên là tao");
//		u1.setRoleID(2);
//		u1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
////		user.updateState(u1);
//		
////		System.out.println(user.checkExistUsername("trungtranad"));
//		System.out.println(user.checkExistEmai("abcd@gmail.com"));
////		user.insertRegister(u1);
//		
//		
//	}
	@Override
	public List<User> findAllUser() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public void update(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			long currentTimeMillis = System.currentTimeMillis();
			Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
			user.setModifiedAt(currentTimestamp);
			
			enma.merge(user);
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
	public User findOne(String username) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM User u " +
					  "WHERE u.username = :username ";
		TypedQuery<User> query = enma.createQuery(jpql, User.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}
	@Override
	public User findOne(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM User u " +
					  "WHERE u.userID = :id ";
		TypedQuery<User> query = enma.createQuery(jpql, User.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	@Override
	public void insertRegister(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			long currentTimeMillis = System.currentTimeMillis();
			Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
			user.setCreatedAt(currentTimestamp);
			
			enma.persist(user);
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
	public void updateState(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		
		try {	
			trans.begin();
			
			String jpql = "UPDATE User u " +
						  "SET u.state = :newState, u.code = :newCode, u.modifiedAt = :modifiedAt " +
						  "WHERE u.email = :email";
			Query query = enma.createQuery(jpql);
			query.setParameter("newState", user.getState());
			query.setParameter("newCode", user.getCode());
			query.setParameter("email", user.getEmail());
			
			long currentTimeMillis = System.currentTimeMillis();
			Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
			query.setParameter("modifiedAt", currentTimestamp);
			
			int updatedCount = query.executeUpdate();
			
			trans.commit();
			System.out.println("Number of records updated: " + updatedCount);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}
	@Override
	public void delete(int id) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User user = enma.find(User.class, id);
			if (user != null) {
				enma.remove(user);
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
	@Override
	public boolean checkExistEmai(String email) {
		boolean duplicate = false;
		EntityManager enma = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT u FROM User u " +
					  	  "WHERE u.email = :email ";
		TypedQuery<User> query = enma.createQuery(jpql, User.class);
		query.setParameter("email", email);
		
		int count = query.getResultList().size();
		if (count>0) {
			duplicate = true;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			enma.close();
		}
		
		return duplicate;
	}
	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		EntityManager enma = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT u FROM User u " +
					  	  "WHERE u.username = :username ";
		TypedQuery<User> query = enma.createQuery(jpql, User.class);
		query.setParameter("username", username);
		
		int count = query.getResultList().size();
		if (count>0) {
			duplicate = true;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			enma.close();
		}
		
		return duplicate;
	}

}
