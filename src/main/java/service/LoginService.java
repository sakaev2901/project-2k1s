package service;

import dao.UserDaoImpl;
import models.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

public class LoginService {

    public boolean checkLoginAndPassword(HttpServletRequest request, HttpServletResponse response) {
        UserDaoImpl userDao = new UserDaoImpl();
        Integer userId = userDao.findByPasswordAndLogin(request.getParameter("login"), request.getParameter("password"));
        if (userId != null) {
            request.getSession().setAttribute("user", userId);
            String[] remembered = request.getParameterValues("remember");
            if (remembered != null && remembered[0].equals("on")) {
                CookieService cookieService = new CookieService(request, response);
                cookieService.sendCookieToDatabase();
            }
            return true;
        }
        return false;
    }
}
