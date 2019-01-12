package mate.academy.jpahw.dao;

import mate.academy.jpahw.dao.crud.CrudDao;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

public interface TestDao extends CrudDao<Test, Long> {
    Test createTest(Patient patient);
}
