package dao;

import models.Question;
import models.Word;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.List;

public class WordDaoImpl implements WordDao {

    public static final String INSERT_LINKING = "INSERT INTO public.dictionary_word (id_dictionary, id_word) VALUES(?, ?);";
    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String INSERT = "INSERT INTO public.word (word, translation, correct_answers, photo) VALUES(?, ?, ?, ?);";
    public static final String FIND = "SELECT * FROM word WHERE \"id\"=?";
    public final String UPDATE_PROGRESS = "UPDATE word SET \"correct_answers\" = ? WHERE \"id\"=?";

    @Override
    public int save(Word model) {
        return 0;
    }

    @Override
    public int save(Word model, Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getWord());
            statement.setString(2, model.getTranslation());
            statement.setInt(3, 5);
            if (model.getPhoto() != null) {
                statement.setBinaryStream(4, model.getPhoto());
            } else {
                statement.setBinaryStream(4, null);
            }
            int result = statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            if (set.next()) {
                model.setId(set.getInt(1));
            }
            PreparedStatement statementLinking = connection.prepareStatement(INSERT_LINKING);
            statementLinking.setInt(1, id);
            statementLinking.setInt(2, model.getId());
            statementLinking.executeUpdate();

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }

    @Override
    public void update(Word model) {

    }

    @Override
    public Word find(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Word word = new Word();
                word.setId(id);
                word.setWord(set.getString("word"));
                word.setTranslation(set.getString("translation"));
                word.setCorrectAnswers(set.getInt("correct_answers"));
                return word;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public List<Word> findAll() {
        return null;
    }

    @Override
    public void updateProgress(boolean isCorrect, Word word) {
        Connection connection = null;
        PreparedStatement statement = null;
        Integer currentProgress = word.getCorrectAnswers();
        if (isCorrect) {
            currentProgress++;
        } else {
            currentProgress--;
        }
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(UPDATE_PROGRESS);
            statement.setInt(1,currentProgress);
            statement.setInt(2, word.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }


    }


}
