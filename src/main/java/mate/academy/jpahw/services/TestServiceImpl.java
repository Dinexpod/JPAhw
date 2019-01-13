package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import java.util.List;

public class TestServiceImpl implements TestService {
   private final TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test createTest(Test test) {
        return this.testDao.save(test);
    }
}
