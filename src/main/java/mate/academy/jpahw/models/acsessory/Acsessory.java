package mate.academy.jpahw.models.acsessory;

import mate.academy.jpahw.models.devices.Device;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acsessories")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Acsessory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "acsessory_id")
    private Long id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private String brand;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Device ownerAcsessory;

    public Acsessory() {
    }

    public Acsessory(String name, String model, String brand) {
        this.name = name;
        this.model = model;
        this.brand = brand;
    }

    public Device getOwnerAcsessory() {
        return ownerAcsessory;
    }

    public void setOwnerAcsessory(Device ownerAcsessory) {
        this.ownerAcsessory = ownerAcsessory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Acsessory{" +
                ", name='" + name + '\'' +
                ", models='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
