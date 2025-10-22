package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.entity.User;
import vn.iotstar.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override

	public void insert(User user) {

		userDao.insert(user);

	}

	@Override

	public void update(User user) {

		userDao.update(user);

	}

	@Override

	public void delete(int cateid) throws Exception {

		userDao.delete(cateid);

	}

	@Override

	public User findById(int cateid) {

		return userDao.findById(cateid);

	}

	@Override

	public List<User> findAll() {

		return userDao.findAll();

	}

	@Override

	public User findByName(String username) {

		return userDao.findByName("userName",username);

	}

	@Override
	public User login(String username, String password) {
		User user = this.findByName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return user;
	}

	@Override

	public List<User> findAll(int page, int pagesize) {

		return userDao.findAll(true, page, pagesize);

	}

	@Override

	public Long count() {

		return userDao.countAll();

	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
	@Override
	public boolean register(String username, String password,
	String email, String fullname, String phone ) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new User(0,email, username, fullname,password,null,5,phone,date));
		return true;
	}
}
