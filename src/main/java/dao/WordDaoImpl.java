package dao;

import models.Word;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.List;

public class WordDaoImpl implements WordDao {

    public static final String INSERT_LINKING = "INSERT INTO public.dictionary_word (id_dictionary, id_word) VALUES(?, ?);";
    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String INSERT = "INSERT INTO public.word (word, translation, correct_answers) VALUES(?, ?, ?);";
    public static final String FIND = "SELECT * FROM word WHERE \"id\"=?";

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
            int result = statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            if (set.next()) {
                model.setId(set.getInt(1));
            }
            PreparedStatement statementLinking = connection.prepareStatement(INSERT_LINKING);
            statementLinking.setInt(1, id);
            statementLinking.setInt(2, model.getId());
            statement.setInt(3, 0);
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
}
