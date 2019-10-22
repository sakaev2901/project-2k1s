package dao;

import models.Word;

import java.util.LinkedList;

public interface DictionaryWordDao {
    LinkedList<Word> find(Integer id);
}
