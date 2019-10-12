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
    public static final String FIND = "SELECT * FROM dictionary WHERE \"id\"=?";



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
        Connection connection = null;
        PreparedStatement statement = null;
        DictionaryWordDaoImpl dictionaryWordDao = new DictionaryWordDaoImpl();
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Dictionary dictionary = new Dictionary();
                dictionary.setId(id);
                dictionary.setName(set.getString("name"));
                dictionary.setDictionary(dictionaryWordDao.find(id));
                return dictionary;
            } else  {
                return null;
            }
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
        finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Dictionary> findAll() {
        return null;
    }

}
