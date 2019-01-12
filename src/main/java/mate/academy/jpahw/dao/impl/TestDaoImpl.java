package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;

public class TestDaoImpl extends AbstractDao<Test, Long> implements TestDao {
    public TestDaoImpl(EntityManager em, Class<Test> testClass) {
        super(em, testClass);
    }
}
