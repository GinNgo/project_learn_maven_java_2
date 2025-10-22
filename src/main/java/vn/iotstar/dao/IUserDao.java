package vn.iotstar.dao;

import vn.iotstar.entity.User;

public interface IUserDao extends IEntityDao<User> {

	boolean checkExistPhone(String phone);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);
}
