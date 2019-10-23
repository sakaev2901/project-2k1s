package controllers;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("user");
        if (userId != null) {
//            req.setAttribute("list", user.getDictionaryIdAndNameAsMap());
//            req.setAttribute("user", user.getLogin());
//            req.getRequestDispatcher("/profile.ftl").forward(req, resp);
            resp.getWriter().write("So fassssssst");
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
