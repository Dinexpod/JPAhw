package mate.academy.jpahw.models.devices;

import mate.academy.jpahw.Main;
import mate.academy.jpahw.models.acsessory.PhotometerAcsessory;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.SkinTest;
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

import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessoryState.APPLIED;
import static mate.academy.jpahw.models.acsessory.PhotometerAcsessory.PAcsessoryState.UNAPPLIED;

@Entity
@Table(name = "photomeeters")
public class Photometer extends Device {
    private static EntityManager em = Main.getEm();

    @Column
    private Integer weight;
    @Column(name = "qr_code")
    private String qrCode;
    @Column
    private Double cost;
    @Column
    @OneToMany(mappedBy = "ownerPhotometer", fetch = FetchType.EAGER)
    protected List<PhotometerAcsessory> photometerAcsessories = new ArrayList<>(1);

    @Override
    public Test doTest(Patient patient) {
        super.doTest(patient);
        System.out.print("by PHOTOMETER for " + patient.getName());
        SkinTest skinTest = createSkinTest();
        System.out.println("\n" + skinTest.toString());
        return skinTest;
    }

    private SkinTest createSkinTest() {
        return new SkinTest("SkinTest",
                Test.Type.FOR_ADULT,
                LocalDateTime.now(),
                1200.0,
                "dsjkf",
                SkinTest.State.EXECUTED);
    }

    public Device turnOnAcsessory(Object acsessory) {
        PhotometerAcsessory photometerAcsessory = (PhotometerAcsessory) acsessory;
        photometerAcsessories.add(photometerAcsessory);
        photometerAcsessory.setState(APPLIED);
        avaliableAcsessory = true;
        System.out.println("Photometer acsessory turned ON");
        return this;
    }

    public Device turnOffAcsessory(Object acsessory) {
        PhotometerAcsessory photometerAcsessory = (PhotometerAcsessory) acsessory;
        photometerAcsessories.remove(photometerAcsessory);
        photometerAcsessory.setState(UNAPPLIED);
        avaliableAcsessory = false;
        System.out.println("Photometer acsessory turned OFF");
        return this;
    }

    public Photometer() {
    }

    public Photometer(String name, String model, String brand, Integer weight, String qrCode, Double cost, EntityManager em) {
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
        return "Photometr{" +
                "weight=" + weight +
                ", qrCode='" + qrCode + '\'' +
                ", cost=" + cost +
                '}';
    }
}
