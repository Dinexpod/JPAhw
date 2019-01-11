package mate.academy.jpahw.tests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDateTime;

@Entity(name = "tests")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "test_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private Type type;
    @Column(name = "date")
    private LocalDateTime localDate;

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

    public Test(String name, Type type, LocalDateTime date) {
        this.name = name;
        this.type = type;
        this.localDate = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
                "name='" + name + '\'' +
                ", type=" + type +
                ", date='" + localDate + '\'' +
                '}';
    }
}
