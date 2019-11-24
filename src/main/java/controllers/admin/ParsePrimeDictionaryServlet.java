package controllers.admin;

import dao.DictionaryDaoImpl;
import dao.PrimeDictionaryDaoImpl;
import models.Dictionary;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import service.DictionaryService;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "ParsePrimeDictionaryServlet", urlPatterns = "/parse")
public class ParsePrimeDictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/parsePrimeDictionary.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DictionaryService dictionaryService = new DictionaryService();
        List<FileItem> items;
        String name = null;
        InputStream inputStream = null;
        try {
            items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
            for (FileItem item:
                    items) {
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    if(fieldName.equals("name")) {
                        name = fieldValue;
                    }
                } else {
                    // Process form file field (input type="file").
                    String fieldName = item.getFieldName();
                    String fileName = FilenameUtils.getName(item.getName());
                    inputStream = item.getInputStream();
                }
            }
        } catch (FileUploadException | IOException e) {
            throw new IllegalStateException(e);
        }
        Dictionary dictionary = dictionaryService. parseFile(" - ", inputStream, name);
        PrimeDictionaryDaoImpl primeDictionaryDao = new PrimeDictionaryDaoImpl();
        primeDictionaryDao.save(dictionary);
        HttpSession session = req.getSession();
        session.setAttribute("dictionary", dictionary);
        resp.sendRedirect("createPrimeDictionary");
    }
}