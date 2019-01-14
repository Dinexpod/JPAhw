package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.models.tests.Test;

import java.util.List;

public class TestServiceImpl implements TestService {
    private final TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test save(Test test) {
        return this.testDao.save(test);
    }

    @Override
    public Test findById(Long id) {
        return this.testDao.findById(id);
    }

    @Override
    public List<Test> findAll() {
        return this.testDao.findAll();
    }

    @Override
    public void delete(Test test) {
        this.testDao.delete(test);
    }

    @Override
    public void deleteById(Long id) {
        this.testDao.deleteById(id);
    }
}
