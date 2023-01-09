package gr.hua.dit.ergasia.omada28.DAO;

import gr.hua.dit.ergasia.omada28.Entity.Contract;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class ContractDaoImpl implements  ContractDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Contract> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Contract ", Contract.class);
        List<Contract> contracts = query.getResultList();
        return contracts;
    }

    @Override
    @Transactional
    public void save(Contract contract) {
        Contract acontract = entityManager.merge(contract);

    }

    @Override
    @Transactional
    public Contract findById(int id) {
        return entityManager.find(Contract.class, id);
    }


}



