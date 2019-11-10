package dao;

import models.Question;
import models.Word;

import java.util.List;

public interface WordDao extends BaseDao<Word> {

    int save(Word model, Integer id);

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

    void updateProgress(boolean isCorrect, Word word);
}
