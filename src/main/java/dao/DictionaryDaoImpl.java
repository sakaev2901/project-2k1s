package dao;

import models.Dictionary;
import models.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.print.DocFlavor;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DictionaryDaoImpl implements DictionaryDao {

    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public final String INSERT = "INSERT INTO public.dictionary (name) VALUES(?)";
    public final String INSERT_LINKING = "INSERT INTO public.user_dictionary (id_user, id_dictionary) VALUES(?, ?)";
    public final String FIND = "SELECT * FROM dictionary WHERE \"id\"=?";
    private final String FIND_NAME = "SELECT * FROM dictionary WHERE \"id\" = ?;";


    @Override
    public int save(Dictionary model) {
        return 0;
    }

    @Override
    public int save(Dictionary model, Integer userId) {
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
            statement1.setInt(1, userId);
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

    public String findName(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND_NAME);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            String dictionaryName = null;
            if (set.next()) {
                dictionaryName = set.getString("name");
            }
            return dictionaryName;
        } catch (SQLException e) {

        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
        return null;
    }

}
