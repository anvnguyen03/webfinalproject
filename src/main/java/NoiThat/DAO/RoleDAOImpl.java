package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import NoiThat.Entity.UserRole;
import NoiThat.JPAConfig.JPAConfig;

public class RoleDAOImpl implements IRoleDAO{

	@Override
	public List<UserRole> findAllRole() {
//		EntityManager enma = JPAConfig.getEntityManager();
//		
//		TypedQuery<UserRole> query = enma.createNamedQuery("UserRole.findAll", UserRole.class);
//		return query.getResultList();
		
		List<UserRole> userroles = null;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			
			TypedQuery<UserRole> query = enma.createNamedQuery("UserRole.findAll", UserRole.class);
			
			userroles = query.getResultList();
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		return userroles;
	}

}
