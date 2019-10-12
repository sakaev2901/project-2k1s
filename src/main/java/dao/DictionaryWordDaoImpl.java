package dao;

import models.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DictionaryWordDaoImpl implements DictionaryWordDao {
    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public static final String FIND = "SELECT * FROM dictionary_word WHERE \"id_dictionary\"=?";
    @Override
    public LinkedList<Word> find(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        WordDaoImpl wordDao = new WordDaoImpl();
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            LinkedList<Word> linkedList = new LinkedList<>();
            while (set.next())  {
                linkedList.add(wordDao.find(set.getInt("id_word")));
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
