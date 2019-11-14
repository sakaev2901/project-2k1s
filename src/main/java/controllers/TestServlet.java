package controllers;

import models.Question;
import service.AnswerCheckerService;
import service.CreateTestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/dictionary/test/*")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO: сделать по красоте без потворения кода
        String url = req.getPathInfo();
        url = url.substring(1, url.length());
        Integer testid = Integer.parseInt(url);
        CreateTestService createTestService = new CreateTestService(testid);
        Question question = createTestService.getQuestion();
        HttpSession session = req.getSession();
        List<String> list = question.getRandomAnswersAsList();
        session.setAttribute("question", question);
        session.setAttribute("answersList", list);
        req.setAttribute("word", question.getWord().getWord());
        req.setAttribute("answer1", list.get(0));
        req.setAttribute("answer2", list.get(1));
        req.setAttribute("answer3", list.get(2));
        req.setAttribute("answer4", list.get(3));
        req.getRequestDispatcher("/question.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Question currentQuestion = (Question)session.getAttribute("question");
        session.removeAttribute("question");
//        session.removeAttribute("answersList");
        String[] answer = req.getParameterValues("answer");
        AnswerCheckerService answerCheckerService = new AnswerCheckerService();

        req.setAttribute("word", currentQuestion.getWord().getWord());
        if (!answerCheckerService.checkAnswer(currentQuestion, answer[0])) {
            req.setAttribute("wrongAnswer", answer[0]);
            req.setAttribute("correctAnswer", currentQuestion.getCorrectAnswer());
        }
        req.getRequestDispatcher("/questionResult.ftl").forward(req, resp);
    }
}
