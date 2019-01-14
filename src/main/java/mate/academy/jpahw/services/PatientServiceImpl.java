package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.PatientDao;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import java.time.LocalDateTime;
import java.util.List;

public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Patient save(Patient patient) {
        return this.patientDao.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        return this.patientDao.findById(id);
    }

    @Override
    public List<Patient> findAll() {
        return this.patientDao.findAll();
    }

    @Override
    public void delete(Patient patient) {
        this.patientDao.delete(patient);
    }

    @Override
    public void deleteById(Long id) {
        this.patientDao.deleteById(id);
    }

    @Override
    public List<Test> getAllTestsInDateRange(LocalDateTime from, LocalDateTime to) {
        return this.patientDao.getAllTestsInDateRange(from, to);
    }

    @Override
    public List<Test> getAllTests() {
        return this.patientDao.getAllTests();
    }
}
