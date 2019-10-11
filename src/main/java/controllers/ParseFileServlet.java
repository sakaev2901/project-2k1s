package controllers;

import models.Dictionary;
import service.DictionaryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Map;

@MultipartConfig
@WebServlet(name = "ParseFileServlet", urlPatterns = "/parsing")
public class ParseFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/inputFile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DictionaryService service = new DictionaryService();
        Part filePart = req.getPart("file");
        String fileName = getSubmittedFileName(filePart);
        InputStream fileContent = filePart.getInputStream();
        String dictionaryName = req.getParameter("name");
        Map<String, String> map = service.parseFile(" - ", fileContent, dictionaryName);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("windows-1251");
        req.setAttribute("word", map.get("approximately"));
        req.getRequestDispatcher("/parseResult.ftl").forward(req, resp);
    }

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
