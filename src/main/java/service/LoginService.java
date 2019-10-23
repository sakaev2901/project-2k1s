package service;

import dao.UserDaoImpl;
import models.User;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

public class LoginService {

    public boolean checkLoginAndPassword(HttpServletRequest request, HttpSession session) {
        UserDaoImpl userDao = new UserDaoImpl();
        Integer userId = userDao.findByPasswordAndLogin(request.getParameter("login"), request.getParameter("password"));
        if (userId != null) {
            session.setAttribute("user", userId);
            return true;
        }
        return false;
    }
}
