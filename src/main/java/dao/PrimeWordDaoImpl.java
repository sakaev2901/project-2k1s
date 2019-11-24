package dao;

import models.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrimeWordDaoImpl {
    private static final ConnectionConfig CONFIG = new ConnectionConfig();
    private static final String SAVE = "INSERT INTO prime_word(word, translation, photo_path, speech_path) values (?, ?, ?, ?)";
    private static final String M2M_PRIME_DICTIONARY = "";
    public static final String UPDATE_PATHS = "UPDATE word set \"photo_path\" = ?,  \"speech_path\" = ? where \"id\" = ?;";

    public Integer save(Word model, String imageExtension, Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(SAVE);
            statement.setString(1, model.getWord());
            statement.setString(2, model.getTranslation());
            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            Integer wordId = null;
            if(set.next()) {
                wordId  = set.getInt(1);
            }
            model.setId(wordId);
            String pathImage = "/images/" + wordId + "." +imageExtension;
            String pathSpeech = "/speech/" + wordId + ".mp3";
            statement = connection.prepareStatement(UPDATE_PATHS);
            statement.setString(1, pathImage);
            statement.setString(2, pathSpeech);
            statement.setInt(3, wordId);
            statement.executeUpdate();PreparedStatement statementLinking = connection.prepareStatement(INSERT_LINKING);
            statementLinking.setInt(1, id);
            statementLinking.setInt(2, model.getId());
            statementLinking.executeUpdate();

            return wordId;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }
}
