package pb.testphone.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pb.testphone.domain.Phone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PhoneRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Phone phone) {
        if (phone.getId() == null) {
            em.persist(phone);
        } else {
            em.merge(phone);
        }
    }

    public Phone findOne(Long id) {
        return em.find(Phone.class, id);
    }

    public List<Phone> findByName(String name) {
        return em.createQuery("select p from Phone p where p.name =: name", Phone.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Phone> findByOS(String osName) {
        return em.createQuery("select p from Phone p where p.osName =: osName", Phone.class)
                .setParameter("osName", osName)
                .getResultList();
    }

    public List<Phone> findAll() {
        return em.createQuery("select p from Phone p", Phone.class).getResultList();
    }
}
