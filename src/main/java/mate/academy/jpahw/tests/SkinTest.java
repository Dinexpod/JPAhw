package mate.academy.jpahw.tests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "skin_tests")
public class SkinTest extends Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "skin_test_id")
    private Integer id;
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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
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
