package mate.academy.jpahw.services;

import mate.academy.jpahw.models.acsessory.Acsessory;

import java.util.List;

public interface AcsessoryService {
    Acsessory save(Acsessory acsessory);

    Acsessory findById(Long id);

    List<Acsessory> findAll();

    void delete(Acsessory entity);

    void deleteById(Long aLong);
}
