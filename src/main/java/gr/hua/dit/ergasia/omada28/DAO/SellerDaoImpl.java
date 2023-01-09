package gr.hua.dit.ergasia.omada28.DAO;


import gr.hua.dit.ergasia.omada28.Entity.Seller;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SellerDaoImpl implements SellerDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Seller> findall(){
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Seller ", Seller.class);
        List<Seller> sellers = query.getResultList();
        return  sellers;
    }

    @Override
    @Transactional
    public void save(Seller seller){
        Seller aseller = entityManager.merge(seller);
    }

    @Override
    @Transactional
    public Seller findById(int id) {
        return entityManager.find(Seller.class, id);
    }



}
