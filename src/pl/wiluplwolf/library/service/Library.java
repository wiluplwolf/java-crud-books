package pl.wiluplwolf.library.service;

import java.util.List;
import java.util.Optional;

public interface Library<T> {
    T create(T t);
    Optional<T> read(long id);
    List<T> readAll();
    void update(long id, T t);
    void delete(long id);
}
