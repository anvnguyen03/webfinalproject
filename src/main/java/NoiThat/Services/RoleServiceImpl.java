package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.IRoleDAO;
import NoiThat.DAO.RoleDAOImpl;
import NoiThat.Entity.UserRole;

public class RoleServiceImpl implements IRoleService{

	IRoleDAO role = new RoleDAOImpl();
	@Override
	public List<UserRole> findAllRole() {
		return role.findAllRole();
	}

}
