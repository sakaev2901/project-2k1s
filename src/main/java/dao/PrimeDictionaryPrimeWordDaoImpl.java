package dao;

import models.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PrimeDictionaryPrimeWordDaoImpl {
    public static final ConnectionConfig CONFIG = new ConnectionConfig();

    public final String FIND = "SELECT * FROM prime_dictionary_prime_word WHERE \"dictionary_id\"=?";

    public LinkedList<Word> find(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        PrimeWordDaoImpl primeWordDao = new PrimeWordDaoImpl();
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            LinkedList<Word> linkedList = new LinkedList<>();
            while (set.next())  {
                linkedList.add(primeWordDao.find(set.getInt("word_id")));
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
