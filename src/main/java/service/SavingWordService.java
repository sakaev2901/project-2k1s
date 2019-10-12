package service;

import dao.WordDaoImpl;
import models.Dictionary;
import models.Word;

public class SavingWordService {
    public void saveDictionaryAsWords(Dictionary dictionary) {
        WordDaoImpl wordDao = new WordDaoImpl();
        for (Word word:
             dictionary.getDictionary()) {
            wordDao.save(word, dictionary.getId());
        }
        System.out.println(dictionary);
    }
}
