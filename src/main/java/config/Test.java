package config;

import dao.DictionaryDaoImpl;
import dao.UserDaoImpl;
import models.Dictionary;
import models.Question;
import models.User;
import models.Word;
import service.CreateTestService;
import service.DictionaryService;
import service.RegistrationService;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
        Dictionary dictionary = dictionaryDao.find(16);
        Word word = new Word("rumor", "слухи");
        CreateTestService createTestService = new CreateTestService(16);
        Question question =createTestService.getQuestion();
        List<String> list = createTestService.getQuestion().getRandomAnswersAsList();
        System.out.println(3);

    }
}
