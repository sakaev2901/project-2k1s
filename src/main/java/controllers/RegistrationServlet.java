package controllers;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
@WebServlet(name = "RegistrationServlet", urlPatterns = "/")
public class RegistrationServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
        try {
            cfg.setDirectoryForTemplateLoading(new File("/WEB-INF/template"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        cfg.setDefaultEncoding("UTF-8");

        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        cfg.setLogTemplateExceptions(false);

        cfg.setWrapUncheckedExceptions(true);

        cfg.setFallbackOnNullLoopVariable(false);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String path = "/example.ftl";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
