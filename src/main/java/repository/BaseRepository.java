package repository;

import java.sql.SQLException;

public interface BaseRepository<T> {

    T create(T t) throws SQLException;
    T read(T t) throws SQLException;
    void update(T t);
    void delete(T t);
}


