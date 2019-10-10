package dao;

import models.User;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/project2k1s";
    private static final String ID = "postgres";
    private static final String PASS = "elvin2901";

    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM user ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String FIND_BY_LOGIN = "SELECT * FROM public.user WHERE \"login\"=?";

    private static final String INSERT = "INSERT INTO public.user (login, firstname, surname, birthday, mail, phone, password) VALUES(?, ?, ?, ?, ?, ?, ?)";
//    private static final String UPDATE = "UPDATE user SET name=?, tel=?, passwd=? WHERE id=?";

    @Override
    public int save(User model) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getFirstName());
            statement.setString(3, model.getSurName());
            statement.setString(4, model.getBirthday());
            statement.setString(5, model.getMail());
            statement.setString(6, model.getPhone());
            statement.setString(7, model.getPassword());
            int result = statement.executeUpdate();
            //TODO: obtain generated keys
            return result;
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        } finally {
            close(connection);
            close(statement);
        }
    }

    @Override
    public void update(User model) {

    }

    @Override
    public User find(int id) {
        return null;
    }

    public User findByLogin(String login) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_BY_LOGIN);
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                User user = new User();
                user.setLogin(set.getString("login"));
                user.setFirstName(set.getString("firstname"));
                user.setSurName(set.getString("surname"));
                user.setBirthday(set.getString("birthday"));
                user.setMail(set.getString("mail"));
                user.setPhone(set.getString("phone"));
                user.setPassword(set.getString("password"));

                return user;
            } else {
                return null;
            }
        } catch (SQLException e ) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(statement);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    private static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(DB_URL, ID, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void close(AutoCloseable statement) {
        if (statement != null) {
            try {
                statement.close();
            }
                catch (Exception e) {
                    throw  new RuntimeException(e);
            }
        }
    }
}
