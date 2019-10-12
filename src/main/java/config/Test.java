package config;

import dao.DictionaryDaoImpl;
import dao.UserDaoImpl;
import models.Dictionary;
import models.User;
import service.DictionaryService;
import service.RegistrationService;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user = userDao.findByLogin("ldar");
        System.out.println(user);
    }
}
