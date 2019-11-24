package dao;

import models.User;

public interface UserDao extends BaseDao<User> {
    User findByLogin(String login);

    User findByPasswordAndLogin(String login, String password);
}
