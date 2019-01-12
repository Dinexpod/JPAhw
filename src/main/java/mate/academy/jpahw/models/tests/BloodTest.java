package mate.academy.jpahw.models.tests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "blood_tests")
public class BloodTest extends Test {
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

    @Override
    public String toString() {
        return "BloodTest{" +
                "cost=" + cost +
                ", location=" + location +
                ", State=" + State +
                '}';
    }
}
