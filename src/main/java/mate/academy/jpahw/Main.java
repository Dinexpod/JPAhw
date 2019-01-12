package mate.academy.jpahw;

import mate.academy.jpahw.models.acsessory.PhotometerAcsessory;
import mate.academy.jpahw.models.acsessory.UltrasonicAcsessory;
import mate.academy.jpahw.models.devices.Photometer;
import mate.academy.jpahw.models.devices.UltrasonicDevice;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.patients.PatientService;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessorySize.BIG;
import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessoryState.UNAPPLIED;

public class Main {
    private static EntityManager em;

    public static EntityManager getEm() {
        return em;
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("PatientPU");
        em = emf.createEntityManager();

        Patient patient = new Patient("Tony", "Lev", em);
        Photometer photometr = new Photometer(
                "Photometer",
                "SWE",
                "ww",
                33,
                "sfcewcse",
                354.0,
                em);
        PhotometerAcsessory photometerAcsessory = new PhotometerAcsessory(
                "photometerAcsessory",
                "ABS",
                "DIDC",
                1300.8,
                BIG,
                UNAPPLIED);

        Test skinTest = photometr.turnOnAcsessory(photometerAcsessory).doTest(patient);
        saveTest(skinTest);

        System.out.println("==========================================================");

        Patient patient1 = new Patient("Jack", "Bond", em);
        UltrasonicDevice ultrasonicDevice = new UltrasonicDevice(
                "UltrasonicDevice",
                "SWE",
                "ff",
                44,
                "sfcewcse",
                3454.0,
                em);
        UltrasonicAcsessory ultrasonicAcsessory = new UltrasonicAcsessory(
                "UltrasonicAcsessory",
                "CRV",
                "KNDJ",
                1600.8,
                UltrasonicAcsessory.UAcsessorySize.BIG,
                UltrasonicAcsessory.UAcsessoryState.UNAPPLIED);

        Test ultrasonicTest = ultrasonicDevice.turnOnAcsessory(ultrasonicAcsessory).doTest(patient1);
        saveTest(ultrasonicTest);

        PatientService patientService = new PatientService();
        List<Test> tests = patientService.getAllTests();
        List<Test> tests1 = patientService
                .getAllTestsInDateRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        System.out.println(tests);
        System.out.println(tests1);
    }

    private static void saveTest(Test test) {
        em.getTransaction().begin();
        em.persist(test);
        em.flush();
        em.getTransaction().commit();
    }
}
