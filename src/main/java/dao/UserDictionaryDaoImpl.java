package dao;

import models.Dictionary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class UserDictionaryDaoImpl implements UserDictionaryDao {
    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String FIND = "SELECT * FROM user_dictionary WHERE \"id_user\"=?";
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
}
