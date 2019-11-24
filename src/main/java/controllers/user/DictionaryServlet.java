package controllers.user;

import dao.DictionaryDaoImpl;
import models.Dictionary;
import models.User;
import models.Word;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/dictionary/*")
public class DictionaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        Integer dictionaryId = Integer.valueOf(url.substring(1));
        DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
        Dictionary dictionary = dictionaryDao.find(dictionaryId);
        List<Word> dictionaryList = dictionary.getDictionary();

        req.setAttribute("id", dictionaryId);
        req.setAttribute("dictionary", dictionaryList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dictionary.ftl");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
