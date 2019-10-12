package dao;

import models.Word;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.List;

public class WordDaoImpl implements WordDao {

    public static final String INSERT_LINKING = "INSERT INTO public.dictionary_word (id_dictionary, id_word) VALUES(?, ?);";
    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String INSERT = "INSERT INTO public.word (word, translation) VALUES(?, ?);";

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
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Word> findAll() {
        return null;
    }
}
