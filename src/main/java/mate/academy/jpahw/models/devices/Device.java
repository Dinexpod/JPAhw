package mate.academy.jpahw.models.devices;

import mate.academy.jpahw.models.acsessory.Acsessory;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "device_id")
    private Long id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private String brand;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ownerAcsessory", cascade = CascadeType.ALL)
    private Set<Acsessory> acsessories;

    public Device() {
    }

    public Device(String name, String model, String brand) {
        this.name = name;
        this.model = model;
        this.brand = brand;
    }

    public void addAcsessory(Acsessory acsessory) {
        if (acsessories == null) {
            acsessories = new HashSet<>();
        }
        acsessories.add(acsessory);
    }

    public Set<Acsessory> getAcsessories() {
        return acsessories;
    }

    public void setAcsessories(Set<Acsessory> acsessories) {
        this.acsessories = acsessories;
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
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
