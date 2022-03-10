package pb.testphone.repository;

import org.springframework.stereotype.Repository;
import pb.testphone.domain.Phone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PhoneRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Phone phone) {
        // ??
    }

    public Phone findOne(Long id) {
        return em.find(Phone.class, id);
    }

    public List<Phone> findAll() {
        return em.createQuery("select p from Phone p", Phone.class).getResultList();
    }
}
