package service;

import dao.UserDaoImpl;
import models.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

public class LoginService {

    public boolean checkLoginAndPassword(HttpServletRequest request, HttpServletResponse response) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByPasswordAndLogin(request.getParameter("login"), request.getParameter("password"));
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getId());
            session.setAttribute("role", user.getRole());
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
