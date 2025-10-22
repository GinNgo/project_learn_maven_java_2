package vn.iotstar.service;

import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.entity.User;

public interface IUserService {



	IUserDao userDao =new UserDao();

	Long count();

	List<User> findAll(int page, int pagesize);

	User findByName(String username);

	List<User> findAll();

	User findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(User user);

	void insert(User user);

	User login(String username, String password);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);

	boolean register(String username, String password, String email, String fullname, String phone);

}
