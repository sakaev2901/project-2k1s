package dao;

import models.Dictionary;

import java.sql.*;

public class PrimeDictionaryDaoImpl {
    public static final ConnectionConfig CONFIG = new ConnectionConfig();
    private static final String SAVE = "INSERT INTO prime_dictionary (name) values (?)";

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
}
