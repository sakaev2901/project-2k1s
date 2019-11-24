package dao;

import models.Word;

import java.sql.*;


public class PrimeWordDaoImpl {
    private static final ConnectionConfig CONFIG = new ConnectionConfig();
    private static final String SAVE = "INSERT INTO prime_word(word, translation) values (?, ?)";
    private static final String M2M_PRIME_DICTIONARY = "";
    private static final String UPDATE_PATHS = "UPDATE prime_word set \"photo_path\" = ?,  \"speech_path\" = ? where \"id\" = ?;";
    public static final String INSERT_LINKING = "INSERT INTO prime_dictionary_prime_word (dictionary_id, word_id) VALUES(?, ?);";
    public static final String FIND = "SELECT * FROM prime_word WHERE \"id\"=?";



    public Integer save(Word model, String imageExtension, Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getWord());
            statement.setString(2, model.getTranslation());
            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            Integer wordId = null;
            if(set.next()) {
                wordId  = set.getInt(1);
            }
            model.setId(wordId);
            String pathImage = "/images/prime_words/" + wordId + "." +imageExtension;
            String pathSpeech = "/speech/" + wordId + ".mp3";
            statement = connection.prepareStatement(UPDATE_PATHS);
            statement.setString(1, pathImage);
            statement.setString(2, pathSpeech);
            statement.setInt(3, wordId);
            statement.executeUpdate();
            PreparedStatement statementLinking = connection.prepareStatement(INSERT_LINKING);
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

    public Word find(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CONFIG.getConnection();
            statement = connection.prepareStatement(FIND);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Word word = new Word();
                word.setId(id);
                word.setWord(set.getString("word"));
                word.setTranslation(set.getString("translation"));
                word.setPhotoPath(set.getString("photo_path"));
                word.setSpeechPath(set.getString("speech_path"));
                return word;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONFIG.close(statement);
            CONFIG.close(connection);
        }
    }
}
