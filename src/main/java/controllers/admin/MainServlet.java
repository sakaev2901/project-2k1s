package controllers.admin;

import dao.WordDaoImpl;
import models.Word;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/main")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add_primary_dictionary.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FileItem> items;
        String wordText = "";
        String translation = "";
        InputStream inputStream = null;
        try {
           items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
            for (FileItem item:
                    items) {
                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    if(fieldName.equals("word")) {
                        wordText = fieldValue;
                    } else if (fieldName.equals("translation")) {
                        translation = fieldName;
                    }
                } else {
                    // Process form file field (input type="file").
                    String fieldName = item.getFieldName();
                    String fileName = FilenameUtils.getName(item.getName());
                    inputStream = item.getInputStream();
                }
            }
        } catch (FileUploadException e) {
            throw new IllegalStateException(e);
        }


        Word word = new Word();
        word.setWord(wordText);
        word.setTranslation(translation);
        word.setPhoto(inputStream);
        WordDaoImpl wordDao = new WordDaoImpl();
        wordDao.save(word, 666);
    }
}