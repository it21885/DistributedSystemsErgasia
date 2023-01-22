package gr.hua.dit.ergasia.omada28.DAO;

import java.util.List;
import gr.hua.dit.ergasia.omada28.Entity.Buyer;

public interface BuyerDao {

    public List<Buyer> findAll();
    public void save(Buyer buyer);

    public Buyer findById(int id);
}

