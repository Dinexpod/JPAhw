package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class TestDaoImpl extends AbstractDao<Test, Long> implements TestDao {
    public TestDaoImpl(EntityManager em, Class<Test> testClass) {
        super(em, testClass);
    }

    @Override
    public Test save(Test entity) {
        return super.save(entity);
    }

    @Override
    public Test findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Test> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Test entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
