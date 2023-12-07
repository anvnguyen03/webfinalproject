package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.User;

public interface IUserDAO {
	List<User> findAllUser();
	User findOne(String username);
	User findOne(int id);
	void insertRegister(User user);
	void update(User user);
	void updateState(User user);
	void delete(int id, int state) throws Exception;
	boolean checkExistEmai(String email);
	boolean checkExistUsername(String username);
	
}
