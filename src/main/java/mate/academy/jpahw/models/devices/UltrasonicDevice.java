package mate.academy.jpahw.models.devices;

import mate.academy.jpahw.Main;
import mate.academy.jpahw.models.acsessory.UltrasonicAcsessory;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.BloodTest;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static mate.academy.jpahw.models.acsessory.UltrasonicAcsessory.UAcsessoryState.APPLIED;
import static mate.academy.jpahw.models.acsessory.UltrasonicAcsessory.UAcsessoryState.UNAPPLIED;

@Entity
@Table(name = "Ultrasonic_devices")
public class UltrasonicDevice extends Device {
    private static EntityManager em = Main.getEm();

    @Column
    private Integer weight;
    @Column(name = "qr_code")
    private String qrCode;
    @Column
    private Double cost;
    @Column
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerUltrasonic")
    private List<UltrasonicAcsessory> ultrasonicAcsessories = new ArrayList<>(1);

//    @Override
//    public Test doTest(Patient patient) {
//        super.doTest(patient);
//        System.out.print("by ULTRASONIC DEVICE!");
//        BloodTest bloodTest = createBloodTest(em);
//        System.out.println("\n" + bloodTest.toString());
//        return bloodTest;
//    }

    private BloodTest createBloodTest(EntityManager em) {
        return new BloodTest("UltrasonicTest",
                Test.Type.FOR_ADULT,
                LocalDateTime.now(),
                1600.0,
                "kjefh",
                BloodTest.State.EXECUTED);
    }

    public Device turnOnAcsessory(Object acsessory) {
        UltrasonicAcsessory ultrasonicAcsessory = (UltrasonicAcsessory) acsessory;
        ultrasonicAcsessories.add(ultrasonicAcsessory);
        ultrasonicAcsessory.setState(APPLIED);
        avaliableAcsessory = true;
        System.out.println("Ultrasonic acsessory turned ON");
        return this;
    }

    public Device turnOffAcsessory(Object acsessory) {
        UltrasonicAcsessory ultrasonicAcsessory = (UltrasonicAcsessory) acsessory;
        ultrasonicAcsessories.add(ultrasonicAcsessory);
        ultrasonicAcsessory.setState(UNAPPLIED);
        avaliableAcsessory = false;
        System.out.println("Ultrasonic acsessory turned OFF");
        return this;
    }

    public UltrasonicDevice() {

    }

    public UltrasonicDevice(String name, String model, String brand, Integer weight, String qrCode, Double cost, EntityManager em) {
        super(name, model, brand, em);
        this.weight = weight;
        this.qrCode = qrCode;
        this.cost = cost;

        em.getTransaction().begin();
        em.persist(this);
        em.flush();
        em.getTransaction().commit();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "UltrasonicDevice{" +
                "weight=" + weight +
                ", qrCode='" + qrCode + '\'' +
                ", cost=" + cost +
                '}';
    }
}

