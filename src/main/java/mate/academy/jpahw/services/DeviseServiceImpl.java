package mate.academy.jpahw.services;

import mate.academy.jpahw.dao.DeviceDao;
import mate.academy.jpahw.models.acsessory.Acsessory;
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
    public Test doTest(Test test, Patient patient, Device device) {
        System.out.println("Doing test for " + patient.getName() + device.getAcsessories().toString() + " acsessories ...");
        test.setNameOfPatient(patient.getName());
        test.setNameOfAcsessory(device.getAcsessories().toString());
        return test;
    }

    @Override
    public void turnOnAcsessory(Acsessory acsessory, Device device) {
        acsessory.setOwnerAcsessory(device);
        device.addAcsessory(acsessory);
        System.out.println("Acsessory turned on!");
    }

    @Override
    public void turnOffAcsessory(Acsessory acsessory, Device device) {
        acsessory.setOwnerAcsessory(null);
        device.getAcsessories().remove(acsessory);
        System.out.println("Acsessory turned off!");
    }
}
