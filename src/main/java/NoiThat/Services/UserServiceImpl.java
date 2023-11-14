package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.IUserDAO;
import NoiThat.DAO.UserDAOImpl;
import NoiThat.Entity.User;

public class UserServiceImpl implements IUserService{

	IUserDAO user = new UserDAOImpl();

	@Override
	public List<User> findAllUser() {
		return user.findAllUser();
	}

	@Override
	public User findOne(String username) {
		return user.findOne(username);
	}

	@Override
	public User findOne(int id) {
		return user.findOne(id);
	}

	@Override
	public void insertRegister(User user) {
		this.user.insertRegister(user);
	}

	@Override
	public void update(User user) {
		this.user.update(user);
		
	}

	@Override
	public void updateState(User user) {
		this.user.updateState(user);
		
	}

	@Override
	public void delete(int id) throws Exception {
		this.user.delete(id);
		
	}

	@Override
	public boolean checkExistEmai(String email) {
		return user.checkExistEmai(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return user.checkExistUsername(username);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String code) {
		if (this.user.checkExistEmai(email)) {
			return false;
		}
		if (this.user.checkExistUsername(username)) {
			return false;
		}
		user.insertRegister(new User(username, password, email, 0, code, fullname, 2));
		return true;
	}

	@Override
	public User login(String username, String password) {
		User user_login = this.user.findOne(username);
		if (user_login != null && password.equals(user_login.getPassword())) {
			return user_login;
		}
		return null;
	}
	

}
