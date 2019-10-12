package dao;

import models.Word;

import java.util.List;

public interface WordDao extends BaseDao<Word> {
    @Override
    int save(Word model);

    @Override
    void update(Word model);

    @Override
    Word find(int id);

    @Override
    void delete(int id);

    @Override
    List<Word> findAll();
}
