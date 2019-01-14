package mate.academy.jpahw;

import mate.academy.jpahw.models.acsessory.PhotometerAcsessory;
import mate.academy.jpahw.models.acsessory.UltrasonicAcsessory;
import mate.academy.jpahw.models.devices.Photometer;
import mate.academy.jpahw.models.devices.UltrasonicDevice;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.BloodTest;
import mate.academy.jpahw.models.tests.SkinTest;
import mate.academy.jpahw.models.tests.Test;
import mate.academy.jpahw.services.AcsessoryService;
import mate.academy.jpahw.services.DeviseService;
import mate.academy.jpahw.services.FactoryService;
import mate.academy.jpahw.services.PatientService;
import mate.academy.jpahw.services.TestService;

import java.time.LocalDateTime;

import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessorySize.BIG;
import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessoryState.UNAPPLIED;

public class Main {
    public static void main(String[] args) {
//      CREATE ALL NEEDS SERVICES (factory creates examples classes)
        TestService testService = FactoryService.getTestService();
        DeviseService deviseService = FactoryService.getDeviseService();
        AcsessoryService acsessoryService = FactoryService.getAcsessoryService();
        PatientService patientService = FactoryService.getPatientService();

//      CREATE ALL NEEDS INSTRUMENTS AND PERSONS
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

        Patient tony = new Patient("Tony", "Lev");

        Patient jack = new Patient("Jack", "Bond");

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

//      SAVE ALL NEEDS INSTRUMENTS AND PERSONS
        testService.save(skinTest);

        testService.save(bloodTest);

        deviseService.save(photometr);

        deviseService.save(ultrasonicDevice);

        acsessoryService.save(photometerAcsessory);

        acsessoryService.save(ultrasonicAcsessory);

        patientService.save(tony);
//
        patientService.save(jack);

//      DO TESTS FROM SOME PATIENTS USING DEVICE AND IT'S EQUIPMENT END OUT INFO ABOUT TESTS
        deviseService.turnOnAcsessory(photometerAcsessory, photometr);
        Test skinTestTmp = deviseService.doTest(skinTest, tony, photometr);
        testService.save(skinTest);
        System.out.println(skinTestTmp.toString());

        deviseService.turnOnAcsessory(ultrasonicAcsessory, ultrasonicDevice);
        Test bloodTestTmp = deviseService.doTest(bloodTest, jack, ultrasonicDevice);
        testService.save(bloodTest);
        System.out.println(bloodTestTmp.toString());

//      DO METHODS "GET ALL TESTS" AND "GET ALL TESTS BY SOME DATA RANGE"
        System.out.println("ALL TESTS");
        patientService.getAllTests().stream().forEach(System.out::println);

        System.out.println("DATA RANGE TESTS ");
        patientService.getAllTestsInDateRange
                (LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1))
                .stream().forEach(System.out::println);
    }
}
