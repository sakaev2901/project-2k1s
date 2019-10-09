package service;

import dao.UserDaoImpl;
import models.User;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

public class LoginService {

    public boolean checkLoginAndPassword(HttpServletRequest request, HttpSession session) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByLogin(request.getParameter("login"));
        if (user != null && user.getPassword().equals(request.getParameter("password"))) {
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }
}
