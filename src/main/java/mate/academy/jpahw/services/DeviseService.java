package mate.academy.jpahw.services;

import mate.academy.jpahw.models.acsessory.Acsessory;
import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import java.util.List;

public interface DeviseService {
    Device save(Device acsessory);

    Device findById(Long id);

    List<Device> findAll();

    void delete(Device device);

    void deleteById(Long id);

    Test doTest(Test test, Patient patient, Device device);

    void turnOnAcsessory(Acsessory acsessory, Device device);

    void turnOffAcsessory(Acsessory acsessory, Device device);
}
