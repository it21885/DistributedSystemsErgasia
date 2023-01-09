package gr.hua.dit.ergasia.omada28.DAO;


import gr.hua.dit.ergasia.omada28.Entity.Contractor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ContractorDaoImpl implements ContractorDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public List <Contractor> findall(){
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Contractor", Contractor.class);
        List<Contractor> contractors = query.getResultList();
        return contractors;
    }

    @Override
    @Transactional
    public void save(Contractor contractor){
        Contractor acontractor = entityManager.merge(contractor);
    }

    @Override
    @Transactional
    public Contractor findById(int id) {
        return entityManager.find(Contractor.class, id);
    }
}
