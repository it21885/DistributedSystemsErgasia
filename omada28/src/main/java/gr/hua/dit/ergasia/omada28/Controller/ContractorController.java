package gr.hua.dit.ergasia.omada28.Controller;

import java.util.List;


import gr.hua.dit.ergasia.omada28.Entity.Buyer;
import gr.hua.dit.ergasia.omada28.Entity.Contract;
import gr.hua.dit.ergasia.omada28.Entity.Contractor;
import gr.hua.dit.ergasia.omada28.DAO.ContractorDao;
import gr.hua.dit.ergasia.omada28.DAO.ContractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/contractor")
public class ContractorController {

    @Autowired
    private ContractorDao contractorDao;

    @Autowired ContractDao contractDao;



    @GetMapping("")
    public  List<Contractor> getallContractors(){
        return contractorDao.findall();
    }

    @GetMapping("/{id}")
    public Contractor getById(@PathVariable int id){
        return contractorDao.findById(id);
    }

    @PostMapping("")
    public Contractor save(@RequestBody Contractor contractor){
        contractor.setId(contractor.getId());
        contractorDao.save(contractor);
        return contractor;
    }

    @GetMapping("/{id}/contract")
    public Contract getContractByContractorId(@PathVariable int id){
        Contractor contractor = contractorDao.findById(id);
        return contractor.getContract();
    }


    @PostMapping("/{cid}/contract")
    public Contract addContract(@PathVariable int cid, @RequestBody Contract contract){
        int contractId = contract.getId();
        Contractor contractor = contractorDao.findById(cid);

        if(contractor == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        if(contractId != 0){
            Contract acontract = contractDao.findById(contractId);
            contractor.setContract(acontract);
            contract.setContractor(contractor);
            contractDao.save(acontract);
            contractorDao.save(contractor);
            return acontract;

        }

        contract.setContractor(contractor);
        contractDao.save(contract);
        contractorDao.save(contractor);
        return contract;
    }

    @PostMapping("/{id}/contract/publish")
    public Contract contractorPublish(@PathVariable("id") int id) {
        Contractor contractor = contractorDao.findById(id);


        if (contractor == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Contract contract = contractor.getContract();

        if (contract == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        contract.setContractor_publish("yes");
        contractDao.save(contract);
        return contract;


    }
}
