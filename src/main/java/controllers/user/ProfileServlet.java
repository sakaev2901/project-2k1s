package controllers.user;

import dao.UserDaoImpl;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("user");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.find(userId);
        req.setAttribute("login", user.getLogin());
        req.setAttribute("mail", user.getMail());
        req.getRequestDispatcher("/profilePage.ftl").forward(req, resp);
    }
}
