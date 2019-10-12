package dao;

import models.Dictionary;
import models.User;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String INSERT = "INSERT INTO public.dictionary (name) VALUES(?)";
    public static final String INSERT_LINKING = "INSERT INTO public.user_dictionary (id_user, id_dictionary) VALUES(?, ?)";

    @Override
    public int save(Dictionary model) {
        return 0;
    }

    @Override
    public int save(Dictionary model, User user) {
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
            PreparedStatement statement1 = connection.prepareStatement(INSERT_LINKING);
            statement1.setInt(1, user.getId());
            statement1.setInt(2, model.getId());
            statement1.executeUpdate();
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

    @Override
    public void linkWithUser(Dictionary model) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            connection = CONFIG.getConnection();
//            statement = connection.prepareStatement(INSERT_LINKING);
//            statement.setInt(1, );
//        }
    }
}
