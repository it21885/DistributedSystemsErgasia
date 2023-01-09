package gr.hua.dit.ergasia.omada28.DAO;

import java.util.List;
import gr.hua.dit.ergasia.omada28.Entity.Contract;


public interface ContractDao {
    public List<Contract> findAll();
    public void save (Contract contract);

    public Contract findById(int id);
}


