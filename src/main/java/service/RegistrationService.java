package service;

import dao.UserDaoImpl;
import models.User;

public class RegistrationService {
    User user;

    public void sendToDB(String login, String firstname, String lastname, String birthday, String mail, String phone, String password) {
        this.user = new User(firstname, lastname, birthday, mail, phone, password, login);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.save(user);
    }
}
