package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.DeviceDao;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

public class DeviseServiceImpl implements DeviseService {
    private final DeviceDao deviceDao;

    public DeviseServiceImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public Test doTest(Test test, Patient patient) {
        return this.deviceDao.doTest(test, patient);
    }
}
