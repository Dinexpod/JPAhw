package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.AcsessoryDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.acsessory.Acsessory;
import mate.academy.jpahw.services.AcsessoryService;

import javax.persistence.EntityManager;
import java.util.List;

public class AcsessoryDaoImpl extends AbstractDao<Acsessory, Long> implements AcsessoryDao {
    public AcsessoryDaoImpl(EntityManager em, Class<Acsessory> acsessoryClass) {
        super(em, acsessoryClass);
    }

    @Override
    public Acsessory save(Acsessory entity) {
        return super.save(entity);
    }

    @Override
    public Acsessory findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Acsessory> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Acsessory entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
