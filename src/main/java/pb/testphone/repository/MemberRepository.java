package pb.testphone.repository;

import org.springframework.stereotype.Repository;
import pb.testphone.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).
                getResultList();
    }

//    public List<Member> findByName(String name) {
//        return em.createQuery("select m from Member m where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//    }

    public List<Member> findByDept(String department) {
        return em.createQuery("select m from Member m where m.department = :department", Member.class)
                .setParameter("department", department)
                .getResultList();
    }
}
