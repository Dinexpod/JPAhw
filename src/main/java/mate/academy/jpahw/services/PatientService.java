package mate.academy.jpahw.services;

import mate.academy.jpahw.models.patients.Patient;

import java.util.List;

public interface PatientService {
    Patient save(Patient patient);

    Patient findById(Long id);

    List<Patient> findAll();

    void delete(Patient patient);

    void deleteById(Long id);
}
