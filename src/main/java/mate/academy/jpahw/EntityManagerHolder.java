package mate.academy.jpahw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHolder {
    protected static EntityManager em;

    public static EntityManager getEm() {
        return em;
    }

    static {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("PatientPU");
        em = emf.createEntityManager();
    }
}
