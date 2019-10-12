package dao;

import models.Dictionary;
import models.User;

import java.util.List;

public interface DictionaryDao extends BaseDao<Dictionary> {
    @Override
    int save(Dictionary model);

    int save(Dictionary model, User user);

    @Override
    void update(Dictionary model);

    @Override
    Dictionary find(int id);

    @Override
    void delete(int id);

    @Override
    List<Dictionary> findAll();
}
