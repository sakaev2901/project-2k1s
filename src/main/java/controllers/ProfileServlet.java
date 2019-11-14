package controllers;

import dao.DictionaryDaoImpl;
import dao.UserDictionaryDaoImpl;
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
import java.util.Map;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("user");
        UserDictionaryDaoImpl userDictionaryDao = new UserDictionaryDaoImpl();
        Map<String, Integer> userDictionatyNames = null;
        userDictionatyNames = userDictionaryDao.findAllUserDictionaryNames(userId);
        req.setAttribute("list", userDictionatyNames);
        req.setAttribute("user", userId);
        req.getRequestDispatcher("/profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
