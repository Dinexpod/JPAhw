package mate.academy.jpahw.services;

import mate.academy.jpahw.EntityManagerHolder;
import mate.academy.jpahw.dao.impl.AcsessoryDaoImpl;
import mate.academy.jpahw.dao.impl.DeviceDaoImpl;
import mate.academy.jpahw.dao.impl.PatientDaoImpl;
import mate.academy.jpahw.dao.impl.TestDaoImpl;
import mate.academy.jpahw.models.acsessory.Acsessory;
import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;

public class FactoryService {
    private static final EntityManager em;

    static {
        em = EntityManagerHolder.getEm();
    }

    public TestService getTestService() {
        return new TestServiceImpl(new TestDaoImpl(em, Test.class));
    }

    public DeviseService deviseService() {
        return new DeviseServiceImpl(new DeviceDaoImpl(em, Device.class));
    }

    public AcsessoryService acsessoryService() {
        return new AcsessoryServiceImpl(new AcsessoryDaoImpl(em, Acsessory.class));
    }

    public PatientService patientService() {
        return new PatientServiceImpl(new PatientDaoImpl(em, Patient.class));
    }
}
