package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.DeviceDao;
import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import java.util.List;

public class DeviseServiceImpl implements DeviseService {
    private final DeviceDao deviceDao;

    public DeviseServiceImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public Device save(Device device) {
        return this.deviceDao.save(device);
    }

    @Override
    public Device findById(Long id) {
        return this.deviceDao.findById(id);
    }

    @Override
    public List<Device> findAll() {
        return this.deviceDao.findAll();
    }

    @Override
    public void delete(Device device) {
        this.deviceDao.delete(device);
    }

    @Override
    public void deleteById(Long id) {
        this.deviceDao.deleteById(id);
    }

    @Override
    public Test doTest(Test test, Patient patient) {
        return this.deviceDao.doTest(test, patient);
    }
}
