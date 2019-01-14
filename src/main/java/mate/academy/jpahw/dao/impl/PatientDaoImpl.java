package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.PatientDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.patients.Patient;

import javax.persistence.EntityManager;
import java.util.List;

public class PatientDaoImpl extends AbstractDao<Patient, Long> implements PatientDao {
    public PatientDaoImpl(EntityManager em, Class<Patient> patientClass) {
        super(em, patientClass);
    }

    @Override
    public Patient save(Patient entity) {
        return super.save(entity);
    }

    @Override
    public Patient findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Patient> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Patient entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
