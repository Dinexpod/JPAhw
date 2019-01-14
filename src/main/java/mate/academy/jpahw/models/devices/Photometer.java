package mate.academy.jpahw.models.devices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "photomeeters")
public class Photometer extends Device {
    @Column
    private Integer weight;
    @Column(name = "qr_code")
    private String qrCode;
    @Column
    private Double cost;

    public Photometer() {
    }

    public Photometer(String name, String model, String brand, Integer weight, String qrCode, Double cost) {
        super(name, model, brand);
        this.weight = weight;
        this.qrCode = qrCode;
        this.cost = cost;

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
