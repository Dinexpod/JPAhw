package mate.academy.jpahw.models.tests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tests")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "test_id")
    private Long id;
    @Column
    private String name;
    @Column
    private Type type;
    @Column(name = "date")
    private LocalDateTime localDate;
    @Column
    private String nameOfPatient;
    @Column
    private String nameOfAcsessory;

    public enum Type {
        FOR_KID,
        FOR_ADULT,
        FOR_OLD
    }

    public enum State {
        EXECUTED,
        NOT_EXECUTED
    }

    public Test() {
    }

    public Test(String name, Type type, LocalDateTime localDate) {
        this.name = name;
        this.type = type;
        this.localDate = localDate;
    }

    public String getNameOfAcsessory() {
        return nameOfAcsessory;
    }

    public void setNameOfAcsessory(String nameOfAcsessory) {
        this.nameOfAcsessory = nameOfAcsessory;
    }

    public String getNameOfPatient() {
        return nameOfPatient;
    }

    public void setNameOfPatient(String nameOfPatient) {
        this.nameOfPatient = nameOfPatient;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", localDate=" + localDate +
                ", nameOfPatient='" + nameOfPatient + '\'' +
                ", nameOfAcsessory='" + nameOfAcsessory + '\'' +
                '}';
    }
}
