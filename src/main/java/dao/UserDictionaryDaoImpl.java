package dao;

import models.Dictionary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class UserDictionaryDaoImpl implements UserDictionaryDao {
    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public final String FIND = "SELECT * FROM user_dictionary WHERE \"id_user\"=?";
    public final String FIND_ALL_NAMES = "SELECT * FROM user_dictionary WHERE  \"id_user\"=?;";


    @Override
    public LinkedList<Dictionary> find(Integer userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND);
            statement.setInt(1, userId);
            ResultSet set = statement.executeQuery();
            LinkedList<Dictionary> linkedList = new LinkedList<>();
            while (set.next()) {
                linkedList.add(dictionaryDao.find(set.getInt("id_dictionary")));
            }
            return linkedList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }
    @Override
    public Map<String, Integer> findAllUserDictionaryNames(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Map<String, Integer> mapOfDictionatyNames = new LinkedHashMap<>();
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND_ALL_NAMES);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            DictionaryDaoImpl dictionaryDao = new DictionaryDaoImpl();
            while (set.next()) {
                Integer dictionaryId = set.getInt("id_dictionary");
                mapOfDictionatyNames.put(dictionaryDao.findName(dictionaryId), dictionaryId);
            }
            return mapOfDictionatyNames;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }
}
