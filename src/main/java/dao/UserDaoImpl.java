package dao;

import models.User;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public static final ConnectionConfig CONFIG = new ConnectionConfig();

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
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getFirstName());
            statement.setString(3, model.getSurName());
            statement.setString(4, model.getBirthday());
            statement.setString(5, model.getMail());
            statement.setString(6, model.getPhone());
            statement.setString(7, model.getPassword());
            int result = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                model.setId(resultSet.getInt(1));
            }
            return result;
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        } finally {
            CONFIG.close(connection);
            CONFIG.close(statement);
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
            connection = CONFIG.getConnection();
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
                user.setId(set.getInt("id"));

                return user;
            } else {
                return null;
            }
        } catch (SQLException e ) {
            throw new RuntimeException(e);
        } finally {
            CONFIG.close(connection);
            CONFIG.close(statement);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }



}
