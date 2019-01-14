package mate.academy.jpahw.services;

import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import java.util.List;

public interface TestService{
    Test save(Test test);

    Test findById(Long id);

    List<Test> findAll();

    void delete(Test test);

    void deleteById(Long id);
}
