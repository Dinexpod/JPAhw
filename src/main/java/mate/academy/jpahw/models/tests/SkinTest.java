package mate.academy.jpahw.models.tests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "skin_tests")
public class SkinTest extends Test {
    @Column
    private Double cost;
    @Column
    private String location;
    @Column
    private State State;

    public SkinTest() {
    }

    public SkinTest(String name, Type type, LocalDateTime date, Double cost, String location, SkinTest.State state) {
        super(name, type, date);
        this.cost = cost;
        this.location = location;
        State = state;
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

    public SkinTest.State getState() {
        return State;
    }

    public void setState(SkinTest.State state) {
        State = state;
    }

    @Override
    public String toString() {
        return "SkinTest{" +
                "cost=" + cost +
                ", location=" + location +
                ", State=" + State +
                '}';
    }
}
