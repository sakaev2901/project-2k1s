package dao;

import java.sql.*;

public class CookieDaoImpl implements CookieDao {

    public static final ConnectionConfig CONFIG = new ConnectionConfig();
    private static final String INSERT = "INSERT INTO user_cookie values (?);";
    private static final String SELECT = "SELECT * FROM user_cookie WHERE \"cookie\"=?;";
    private static final String DELETE = "DELETE FROM user_cookie WHERE \"cookie\"=?;";


    @Override
    public void save(String cookie) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, cookie);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        } finally {
            CONFIG.close(connection);
            CONFIG.close(statement);
        }
    }

    @Override
    public boolean find(String cookie) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, cookie);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        } finally {
            CONFIG.close(connection);
            CONFIG.close(statement);
        }
    }

    @Override
    public void delete(String cookie) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(DELETE);
            statement.setString(1, cookie);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        } finally {
            CONFIG.close(connection);
            CONFIG.close(statement);
        }
    }
}
