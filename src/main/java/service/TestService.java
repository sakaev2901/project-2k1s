package service;

import dao.DictionaryDaoImpl;
import models.Dictionary;
import models.Question;
import models.Test;

public class TestService {
    Dictionary dictionary;

    public TestService(int id) {
        DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
        this.dictionary = dictionaryDao.find(id);
    }

    public Question getQuestion() {
        Test test = new Test(this.dictionary);
        return test.createQuestion();
    }
}
