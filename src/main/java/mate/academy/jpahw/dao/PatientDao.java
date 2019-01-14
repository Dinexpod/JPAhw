package mate.academy.jpahw.dao;

import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.dao.crud.CrudDao;
import mate.academy.jpahw.models.patients.Patient;

public interface PatientDao extends CrudDao<Patient, Long> {
}
