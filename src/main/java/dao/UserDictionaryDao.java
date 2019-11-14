package dao;

import models.Dictionary;

import java.util.LinkedList;
import java.util.Map;

public interface UserDictionaryDao {
    LinkedList<Dictionary> find(Integer userId);

    Map<String, Integer> findAllUserDictionaryNames(Integer id);
}
