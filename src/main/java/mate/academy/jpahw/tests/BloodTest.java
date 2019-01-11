package mate.academy.jpahw.tests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "blood_tests")
public class BloodTest extends Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "blood_test_id")
    private Integer id;
    @Column
    private Double cost;
    @Column
    private String location;
    @Column
    private State State;

    public BloodTest(String name, Type type, LocalDateTime date, Double cost, String location, BloodTest.State state) {
        super(name, type, date);
        this.cost = cost;
        this.location = location;
        State = state;
    }

    public BloodTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BloodTest.State getState() {
        return State;
    }

    public void setState(BloodTest.State state) {
        State = state;
    }

    public String customToString() {
        return (super.toString() + "\n" + toString());
    }

    @Override
    public String toString() {
        return "BloodTest{" +
                "cost=" + cost +
                ", location=" + location +
                ", State=" + State +
                '}';
    }
}
