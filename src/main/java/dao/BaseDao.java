package dao;

import java.util.List;

public interface BaseDao<T> {
    int save(T model);
    void update(T model);
    T find(int id);
    void delete(int id);

    List<T> findAll();

}
