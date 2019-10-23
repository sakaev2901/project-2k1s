package controllers;

import models.Dictionary;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/dictionary/*")
public class DictionaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //TODO: fix this shit_1
        User user = (User)session.getAttribute("user");
        String url = req.getPathInfo();
        Integer dictionaryId = Integer.valueOf(url.substring(1));
        Dictionary dictionary = user.getDictionatyById(dictionaryId);
        Map<String, String> dictionaryMap = dictionary.getDictionaryAsMap();
        req.setAttribute("dictionary", dictionaryMap);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dictionary.ftl");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
