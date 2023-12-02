package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.UserRole;

public interface IRoleDAO {

	List<UserRole> findAllRole();
	
}
