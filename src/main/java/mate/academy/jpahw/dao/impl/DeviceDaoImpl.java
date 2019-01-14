package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.DeviceDao;
import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.acsessory.Acsessory;
import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.devices.Photometer;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class DeviceDaoImpl extends AbstractDao<Device, Long> implements DeviceDao {
    public DeviceDaoImpl(EntityManager em, Class<Device> deviceClass) {
        super(em, deviceClass);
    }

    @Override
    public Device save(Device entity) {
        return super.save(entity);
    }

    @Override
    public Device findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Device> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Device entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Test doTest(Test test, Patient patient, Acsessory acsessory) {
        System.out.println("Doing test for " + patient.getName() + " by " + acsessory.getName() + " acsessory ...");
        test.setNameOfPatient(patient.getName());
        test.setNameOfAcsessory(acsessory.getName());
        return test;
    }
}
