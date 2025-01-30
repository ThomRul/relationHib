package repositories.base;

import java.util.List;

public interface ICrudRepository<T, Id> {
    List<T> getAll();
    T getOne(Id id);
    T insert(T entity);
    T update(Id id, T entity);
    T delete(Id id);
}
