package controllers.user;

import models.User;
import service.LoginService;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        String path = "/authorizationPage.ftl";
        HttpSession session = req.getSession();
        //TODO: fix this shit_2
        Integer userId = (Integer) session.getAttribute("user");
        if(userId != null) {
            resp.sendRedirect("profile");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginService();
        HttpSession session = req.getSession();
        loginService.checkLoginAndPassword(req, resp);
        Integer userId = (Integer) session.getAttribute("user");
        String role = (String)session.getAttribute("role");
        Writer writer = resp.getWriter();
        if (userId == null) {
            writer.write("Wrong login or password");
        } else if(role.equals("user")){
            resp.sendRedirect("main");
        } else {
            resp.sendRedirect("adminPanel");
        }
        writer.close();

    }
}
