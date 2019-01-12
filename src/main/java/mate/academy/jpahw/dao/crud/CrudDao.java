package mate.academy.jpahw.dao.crud;

import java.util.List;

public interface CrudDao<T, ID> {
    T save(T entity);

    T findById(ID id);

    List<T> findAll();

    void delete(T entity);

    void deleteById(ID id);
}
