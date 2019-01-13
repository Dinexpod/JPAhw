package mate.academy.jpahw;

import mate.academy.jpahw.dao.AcsessoryDao;
import mate.academy.jpahw.dao.DeviceDao;
import mate.academy.jpahw.dao.TestDao;
import mate.academy.jpahw.dao.impl.AcsessoryDaoImpl;
import mate.academy.jpahw.dao.impl.DeviceDaoImpl;
import mate.academy.jpahw.dao.impl.TestDaoImpl;
import mate.academy.jpahw.models.acsessory.Acsessory;
import mate.academy.jpahw.models.acsessory.PhotometerAcsessory;
import mate.academy.jpahw.models.acsessory.UltrasonicAcsessory;
import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.devices.Photometer;
import mate.academy.jpahw.models.devices.UltrasonicDevice;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.patients.PatientService;
import mate.academy.jpahw.models.tests.BloodTest;
import mate.academy.jpahw.models.tests.SkinTest;
import mate.academy.jpahw.models.tests.Test;
import mate.academy.jpahw.services.AcsessoryService;
import mate.academy.jpahw.services.AcsessoryServiceImpl;
import mate.academy.jpahw.services.DeviseService;
import mate.academy.jpahw.services.DeviseServiceImpl;
import mate.academy.jpahw.services.TestService;
import mate.academy.jpahw.services.TestServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

import static mate.academy.jpahw.EntityManagerHolder.em;
import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessorySize.BIG;
import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessoryState.UNAPPLIED;

public class Main {
    public static void main(String[] args) {
        Test skinTest = new SkinTest("SkinTest",
                Test.Type.FOR_ADULT,
                LocalDateTime.now(),
                1200.0,
                "dsjkf",
                SkinTest.State.EXECUTED);

        Test bloodTest = new BloodTest("UltrasonicTest",
                Test.Type.FOR_ADULT,
                LocalDateTime.now(),
                1600.0,
                "kjefh",
                BloodTest.State.EXECUTED);

        Patient patient = new Patient("Tony", "Lev");
        Patient patient1 = new Patient("Jack", "Bond");

        Photometer photometr = new Photometer(
                "Photometer",
                "SWE",
                "ww",
                33,
                "sfcewcse",
                354.0);

        PhotometerAcsessory photometerAcsessory = new PhotometerAcsessory(
                "photometerAcsessory",
                "ABS",
                "DIDC",
                1300.8,
                BIG,
                UNAPPLIED);

        UltrasonicDevice ultrasonicDevice = new UltrasonicDevice(
                "UltrasonicDevice",
                "SWE",
                "ff",
                44,
                "sfcewcse",
                3454.0);

        UltrasonicAcsessory ultrasonicAcsessory = new UltrasonicAcsessory(
                "UltrasonicAcsessory",
                "CRV",
                "KNDJ",
                1600.8,
                UltrasonicAcsessory.UAcsessorySize.BIG,
                UltrasonicAcsessory.UAcsessoryState.UNAPPLIED);



        TestDao testDao = new TestDaoImpl(em, Test.class);
        DeviceDao deviceDao =  new DeviceDaoImpl(em, Device.class);
        AcsessoryDao acsessoryDao = new AcsessoryDaoImpl(em, Acsessory.class);

        testDao.save(skinTest);
        testDao.save(bloodTest);

        deviceDao.save(photometr);
        deviceDao.save(ultrasonicDevice);

        acsessoryDao.save(photometerAcsessory);
        acsessoryDao.save(ultrasonicAcsessory);


        PatientService patientService = new PatientService();
        List<Test> tests = patientService.getAllTests();
        List<Test> tests1 = patientService
                .getAllTestsInDateRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        System.out.println(tests);
        System.out.println(tests1);
    }
}
