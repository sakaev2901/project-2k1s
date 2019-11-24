package controllers.admin;

import dao.PrimeDictionaryDaoImpl;
import models.Dictionary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminPanelServlet", urlPatterns = "/adminPanel")
public class AdminPanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dictionary> dictionaries = new PrimeDictionaryDaoImpl().findAll();
        req.setAttribute("dictionaries", dictionaries);
        req.getRequestDispatcher("/adminPanel.ftl").forward(req, resp);
    }
}
