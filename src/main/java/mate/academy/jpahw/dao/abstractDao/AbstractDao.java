package mate.academy.jpahw.dao.abstractDao;

import mate.academy.jpahw.dao.crud.CrudDao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDao<T, ID> implements CrudDao<T, ID> {
    protected final EntityManager em;

    protected final Class<T> tClass;

    public AbstractDao(EntityManager em, Class<T> tClass) {
        this.em = em;
        this.tClass = tClass;
    }

    @Override
    public T save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        ID id = (ID) em.createQuery("select max(e.id) from " + tClass.getName() + " e", tClass);
        return findById(id);
    }

    @Override
    public T findById(ID id) {
        em.getTransaction().begin();
        T t =  em.find(tClass, id);
        em.getTransaction().commit();
        return t;
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("select t from " + tClass.getName() + " t", tClass).getResultList();
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(ID id) {
        em.getTransaction().begin();
        em.remove(findById(id));
        em.flush();
        em.getTransaction().commit();
    }
}
