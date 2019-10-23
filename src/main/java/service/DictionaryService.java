package service;

import dao.DictionaryDaoImpl;
import models.Dictionary;
import models.User;
import models.Word;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Map;

public class DictionaryService {

    public Dictionary dictionary;

    public Dictionary parseFile(String separator, InputStream inputStream, String name, HttpSession session) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            String word;
            String translation;
            this.dictionary = new Dictionary();
            dictionary.setName(name);
            while ((line = br.readLine()) != null) {
                word = line.split(" - ")[0];
                translation = new String(line.split(" - ")[1].getBytes(), StandardCharsets.UTF_8);
                dictionary.addWord(new Word(word, translation));
            }
            //TODO: fix this shit_1
            sendToDB((User) session.getAttribute("user"));
            return this.dictionary;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public void sendToDB(User user) {
        DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
        dictionaryDao.save(this.dictionary, user);
    }
}
