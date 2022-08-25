package repository;

import java.sql.SQLException;

public interface BaseRepository<T ,E> {

    void create(T t) throws SQLException;
    T read(E e)  ;                                    //ok
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
}


