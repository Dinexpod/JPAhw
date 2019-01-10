package mate.academy.jpahw;

import mate.academy.jpahw.acsessory.PhotometerAcsessory;
import mate.academy.jpahw.acsessory.UltrasonicAcsessory;
import mate.academy.jpahw.devices.Photometer;
import mate.academy.jpahw.devices.UltrasonicDevice;
import mate.academy.jpahw.patients.Patient;
import mate.academy.jpahw.patients.PatientService;
import mate.academy.jpahw.tests.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
                PhotometerAcsessory.PAcsessorySize.BIG,
                PhotometerAcsessory.PAcsessoryState.UNAPPLIED);

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
        List<Test> tests1 = patientService.getAllTestsInDateRange(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        System.out.println(tests.toString());
        System.out.println(tests1.toString());

    }

    private static void saveTest(Test test) {
        em.getTransaction().begin();
        em.persist(test);
        em.flush();
        em.getTransaction().commit();
    }

    public static List<Test> getPatientByName() {
        TypedQuery<Test> query =
                em
                        .createQuery("select p from tests p ", Test.class);

        return query.getResultList();
    }
}
