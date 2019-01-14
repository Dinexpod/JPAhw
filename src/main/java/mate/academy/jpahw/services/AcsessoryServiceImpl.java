package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.AcsessoryDao;
import mate.academy.jpahw.models.acsessory.Acsessory;

import java.util.List;

public class AcsessoryServiceImpl implements AcsessoryService {
    private final AcsessoryDao acsessoryDao;

    public AcsessoryServiceImpl(AcsessoryDao acsessoryDao) {
        this.acsessoryDao = acsessoryDao;
    }

    @Override
    public Acsessory save(Acsessory acsessory) {
        return this.acsessoryDao.save(acsessory);
    }


    @Override
    public Acsessory findById(Long id) {
        return this.acsessoryDao.findById(id);
    }

    @Override
    public List<Acsessory> findAll() {
        return this.acsessoryDao.findAll();
    }

    @Override
    public void delete(Acsessory acsessory) {
        this.acsessoryDao.delete(acsessory);
    }

    @Override
    public void deleteById(Long is) {
        this.acsessoryDao.deleteById(is);
    }
}
