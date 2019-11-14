package dao;

public interface CookieDao {
    void save(String cookie);
    boolean find(String cookie);
    void delete(String cookie);
}
