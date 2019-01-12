package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.DeviceDao;
import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.devices.Photometer;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;

public class DeviceDaoImpl extends AbstractDao<Device, Long> implements DeviceDao {
    public DeviceDaoImpl(EntityManager em, Class<Device> deviceClass) {
        super(em, deviceClass);
    }

    @Override
    public Test doTest(Patient patient) {
        TestDao testDaoImpl = new TestDaoImpl(em, Test.class);
        System.out.println("Doing test ...");
        Test test = testDaoImpl.createTest(patient);
        return test;
    }
}
