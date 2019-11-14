package dao;

import models.Dictionary;
import models.User;

import java.util.List;
import java.util.Map;

public interface DictionaryDao extends BaseDao<Dictionary> {
    @Override
    int save(Dictionary model);


    int save(Dictionary model, Integer userId);

    @Override
    void update(Dictionary model);

    @Override
    Dictionary find(int id);

    @Override
    void delete(int id);

    @Override
    List<Dictionary> findAll();


}
