package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.AcsessoryDao;
import mate.academy.jpahw.models.acsessory.Acsessory;

public class AcsessoryServiceImpl implements AcsessoryService {
    private final AcsessoryDao acsessoryDao;

    public AcsessoryServiceImpl(AcsessoryDao acsessoryDao) {
        this.acsessoryDao = acsessoryDao;
    }

    @Override
    public Acsessory save(Acsessory acsessory) {
        return this.acsessoryDao.save(acsessory);
    }
}
