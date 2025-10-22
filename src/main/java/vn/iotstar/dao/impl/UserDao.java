package vn.iotstar.dao.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.entity.User;

public class UserDao extends AbstractEntityDao<User> implements IUserDao  {



public UserDao() {

super(User.class);


}
@Override
public boolean checkExistEmail(String email) {
    return checkExist("email", email);
}

@Override
public boolean checkExistUsername(String username) {
    return checkExist("username", username);
}

@Override
public boolean checkExistPhone(String phone) {
    return checkExist("phone", phone);
}


}