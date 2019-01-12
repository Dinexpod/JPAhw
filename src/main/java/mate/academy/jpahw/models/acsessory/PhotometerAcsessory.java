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
@Table(name = "photometer_acsessories")
public class PhotometerAcsessory extends Acsessory {
    @Column
    private Double cost;
    @Column
    private PAcsessorySize size;
    @Column
    private PAcsessoryState state;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "photometer_id")
    private Photometer ownerPhotometer;

    public enum PAcsessoryState {
        APPLIED,
        UNAPPLIED
    }

    public enum PAcsessorySize {
        LITTLE,
        MIDDLE,
        BIG
    }

    public PhotometerAcsessory(String name, String model, String brand, Double cost, PAcsessorySize size, PAcsessoryState state) {
        super(name, model, brand);
        this.cost = cost;
        this.size = size;
        this.state = state;
    }

    public PhotometerAcsessory() {
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public PAcsessorySize getSize() {
        return size;
    }

    public void setSize(PAcsessorySize size) {
        this.size = size;
    }

    public PAcsessoryState getState() {
        return state;
    }

    public void setState(PAcsessoryState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PhotometerAcsessory{" +
                "cost=" + cost +
                ", size=" + size +
                ", state=" + state +
                ", ownerPhotometer=" + ownerPhotometer +
                '}';
    }
}
