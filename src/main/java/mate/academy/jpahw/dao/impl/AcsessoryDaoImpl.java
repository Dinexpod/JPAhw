package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.acsessory.Acsessory;

import javax.persistence.EntityManager;

public class AcsessoryDaoImpl extends AbstractDao<Acsessory, Long> {
    public AcsessoryDaoImpl(EntityManager em, Class<Acsessory> acsessoryClass) {
        super(em, acsessoryClass);
    }
}
