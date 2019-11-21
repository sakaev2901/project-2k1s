package config;

import dao.DictionaryDaoImpl;
import models.Dictionary;
import models.Question;
import models.Word;
import service.TestService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
        Dictionary dictionary = dictionaryDao.find(16);
        Word word = new Word("rumor", "слухи");
        TestService testService = new TestService(16);
        Question question = testService.getQuestion();
        List<String> list = testService.getQuestion().getRandomAnswersAsList();
        System.out.println(3);

    }
}
