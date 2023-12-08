package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.User;

public interface IUserService {
	List<User> findAllUser();
	User findOne(String username);
	User findOne(int id);
	User findByEmail(String email);
	void insertRegister(User user);
	void update(User user);
	void updateState(User user);
	void delete(int id, int state) throws Exception;
	
	boolean register(String email, String password, String username, String fullname, String code);
	User login(String username, String password);
	boolean checkExistEmai(String email);
	boolean checkExistUsername(String username);
}
