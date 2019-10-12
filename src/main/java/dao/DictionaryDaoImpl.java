package dao;

import models.Dictionary;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String INSERT = "INSERT INTO public.dictionary (name) VALUES(?)";

    @Override
    public int save(Dictionary model) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getName());
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
    public void update(Dictionary model) {

    }

    @Override
    public Dictionary find(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Dictionary> findAll() {
        return null;
    }
}
