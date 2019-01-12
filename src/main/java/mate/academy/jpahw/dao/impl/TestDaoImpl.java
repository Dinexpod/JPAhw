package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static mate.academy.jpahw.models.tests.Test.State.EXECUTED;

public class TestDaoImpl extends AbstractDao<Test, Long> implements TestDao {
    public TestDaoImpl(EntityManager em, Class<Test> testClass) {
        super(em, testClass);
    }

    @Override
    public Test createTest(Patient patient) {
        Test test = new Test();

        em.getTransaction().begin();
        em.persist(test);
        em.getTransaction().commit();

        return test;
    }
}
