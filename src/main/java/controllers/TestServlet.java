package controllers;

import models.Question;
import service.CreateTestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateTestService createTestService = new CreateTestService(16);
        Question question = createTestService.getQuestion();
        List<String> list = question.getRandomAnswersAsList();
        req.setAttribute("word", question.getWord());
        req.setAttribute("answer1", list.get(0));
        req.setAttribute("answer2", list.get(1));
        req.setAttribute("answer3", list.get(2));
        req.setAttribute("answer4", list.get(3));
        req.getRequestDispatcher("/test.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
