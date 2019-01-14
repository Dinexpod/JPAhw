package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.PatientDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Test> getAllTestsInDateRange(LocalDateTime from, LocalDateTime to) {
        TypedQuery<Test> query = em
                .createQuery("select p from Test p ", Test.class);
        return query.getResultList()
                .stream()
                .filter(test -> (test.getLocalDate().isAfter(from) && test.getLocalDate().isBefore(to)))
                .collect(Collectors.toList());
    }

    public List<Test> getAllTests() {
        TypedQuery<Test> query = em
                .createQuery("select p from Test p ", Test.class);
        return query.getResultList();
    }
}
