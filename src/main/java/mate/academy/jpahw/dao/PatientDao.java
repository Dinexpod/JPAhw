package mate.academy.jpahw.dao;

import mate.academy.jpahw.dao.crud.CrudDao;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends CrudDao<Patient, Long> {
    List<Test> getAllTestsInDateRange(LocalDateTime from, LocalDateTime to);

    List<Test> getAllTests();
}
