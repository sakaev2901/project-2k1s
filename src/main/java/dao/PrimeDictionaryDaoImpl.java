package dao;

import models.Dictionary;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeDictionaryDaoImpl {
    public static final ConnectionConfig CONFIG = new ConnectionConfig();
    private static final String SAVE = "INSERT INTO prime_dictionary (name) values (?)";
    private static final String FIND_ALL = "SELECT * FROM prime_dictionary";
    public final String FIND = "SELECT * FROM prime_dictionary WHERE \"id\"=?";


    public void save(Dictionary dictionary) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dictionary.getName());
            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            Integer dictionaruId = null;
            if(set.next()) {
                dictionaruId = set.getInt(1);
            }
            dictionary.setId(dictionaruId);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }

    public List<Dictionary> findAll() {
        List<Dictionary> dictionaries = new LinkedList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND_ALL);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Dictionary dictionary = new Dictionary();
                dictionary.setId(set.getInt("id"));
                dictionary.setName(set.getString("name"));
                dictionaries.add(dictionary);
            }
            return dictionaries;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }
    public Dictionary find(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        PrimeDictionaryPrimeWordDaoImpl primeDictionaryPrimeWordDao = new PrimeDictionaryPrimeWordDaoImpl();
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Dictionary dictionary = new Dictionary();
                dictionary.setId(id);
                dictionary.setName(set.getString("name"));
                dictionary.setDictionary(primeDictionaryPrimeWordDao.find(id));
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
}
