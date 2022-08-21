package repository;

public interface BaseRepository<T> {

    void create(T t);
    T read(T t);
    T update(T t);
    void delete(T t);
}


