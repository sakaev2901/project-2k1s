package controllers.admin;

import models.Dictionary;
import service.PrimeDictionaryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "CreatePrimeDictionary", urlPatterns = "/createPrimeDictionary")
public class CreatePrimeDictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Dictionary dictionary = (Dictionary) session.getAttribute("dictionary");
        req.setAttribute("dictionary", dictionary.getDictionary());
        req.getRequestDispatcher("/createPrimeDictionary.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrimeDictionaryService primeDictionaryService = new PrimeDictionaryService();
        primeDictionaryService.parsePrimeDictionary(req);
    }
}
