package dao;

import models.Dictionary;

import java.util.LinkedList;

public interface UserDictionaryDao {
    LinkedList<Dictionary> find(Integer userId);
}
