package mate.academy.jpahw.services;

import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

public interface DeviseService {
    Test doTest(Test test, Patient patient);
}
