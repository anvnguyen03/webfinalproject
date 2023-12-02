package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import NoiThat.Entity.UserRole;
import NoiThat.JPAConfig.JPAConfig;

public class RoleDAOImpl implements IRoleDAO{

	@Override
	public List<UserRole> findAllRole() {
		EntityManager enma = JPAConfig.getEntityManager();
		
		TypedQuery<UserRole> query = enma.createNamedQuery("UserRole.findAll", UserRole.class);
		
		return query.getResultList();
	}

}
