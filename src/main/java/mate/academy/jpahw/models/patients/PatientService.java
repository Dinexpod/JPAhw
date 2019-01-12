package mate.academy.jpahw.models.patients;

import mate.academy.jpahw.Main;
import mate.academy.jpahw.models.tests.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PatientService {
    private static EntityManager em = Main.getEm();

    public List<Test> getAllTests() {
        TypedQuery<Test> query = em
                .createQuery("select p from tests p ", Test.class);
        return query.getResultList();
    }

    public List<Test> getAllTestsInDateRange(LocalDateTime from, LocalDateTime to) {
        TypedQuery<Test> query = em
                .createQuery("select p from tests p ", Test.class);
        return query.getResultList()
                .stream()
                .filter(test -> (test.getLocalDate().isAfter(from) && test.getLocalDate().isBefore(to)))
                .collect(Collectors.toList());
    }
}
