package dao;

import models.Word;

import java.sql.*;
import java.util.List;

public class WordDaoImpl implements WordDao {

    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String INSERT = "INSERT INTO public.word (word, translation) VALUES(?, ?)";
    @Override
    public int save(Word model) {
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
