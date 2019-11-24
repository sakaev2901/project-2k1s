package controllers.admin;

import dao.PrimeDictionaryDaoImpl;
import models.Dictionary;
import models.Word;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PrimeDictionaryServlet", urlPatterns = "/primeDictionary/*")
public class PrimeDictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        Integer dictionaryId = Integer.valueOf(url.substring(1));
        PrimeDictionaryDaoImpl primeDictionaryDao = new PrimeDictionaryDaoImpl();
        Dictionary dictionary = primeDictionaryDao.find(dictionaryId);
        req.setAttribute("dictionary", dictionary.getDictionary());
        req.getRequestDispatcher("/primeDictionary.ftl").forward(req, resp);
    }
}
