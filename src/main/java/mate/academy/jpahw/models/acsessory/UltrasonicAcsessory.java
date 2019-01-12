package mate.academy.jpahw.models.acsessory;

import mate.academy.jpahw.models.devices.Photometer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ultrasonic_acsessories")
public class UltrasonicAcsessory extends Acsessory {
    @Column
    private Double cost;
    @Column
    private UAcsessorySize size;
    @Column
    private UAcsessoryState State;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ultrasonic_id", nullable = false)
    private Photometer ownerUltrasonic;

    public enum UAcsessoryState {
        APPLIED,
        UNAPPLIED
    }

    public enum UAcsessorySize {
        LITTLE,
        MIDDLE,
        BIG
    }

    public UltrasonicAcsessory() {
    }

    public UltrasonicAcsessory(String name, String model, String brand, Double cost, UAcsessorySize size, UAcsessoryState state) {
        super(name, model, brand);
        this.cost = cost;
        this.size = size;
        State = state;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public UAcsessorySize getSize() {
        return size;
    }

    public void setSize(UAcsessorySize size) {
        this.size = size;
    }

    public UAcsessoryState getState() {
        return State;
    }

    public void setState(UAcsessoryState state) {
        State = state;
    }

    @Override
    public String toString() {
        return "UltrasonicAcsessory{" +
                "cost=" + cost +
                ", size=" + size +
                ", State=" + State +
                ", ownerUlrasonic=" + ownerUltrasonic +
                '}';
    }
}
