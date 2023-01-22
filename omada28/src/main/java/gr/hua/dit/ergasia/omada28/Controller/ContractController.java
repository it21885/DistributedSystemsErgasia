package gr.hua.dit.ergasia.omada28.Controller;


import gr.hua.dit.ergasia.omada28.DAO.ContractorDao;
import gr.hua.dit.ergasia.omada28.Entity.Contract;
import gr.hua.dit.ergasia.omada28.Entity.Buyer;
import gr.hua.dit.ergasia.omada28.DAO.BuyerDao;
import gr.hua.dit.ergasia.omada28.DAO.ContractDao;
import gr.hua.dit.ergasia.omada28.DAO.SellerDao;
import gr.hua.dit.ergasia.omada28.Entity.Seller;
//import gr.hua.dit.ergasia.omada28.Repository.ContractorRepository;
//import gr.hua.dit.ergasia.omada28.Repository.SellerRepository;
import gr.hua.dit.ergasia.omada28.Entity.Contractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private BuyerDao buyerDao;

    //@Autowired
    //private SellerRepository sellerRepository;

    //@Autowired
    //private ContractorRepository contractorRepository;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractorDao contractorDao;

    @Autowired
    private SellerDao sellerDao;


    @GetMapping("")
    public List<Contract> getallContracts() {
        return contractDao.findAll();
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable int id) {
        return contractDao.findById(id);
    }

    @PostMapping("")
    public Contract save(@RequestBody Contract contract) {
        contract.setId(contract.getId());
        contractDao.save(contract);
        return contract;
    }


    @PostMapping("/{cid}/buyer")
    public Buyer addBuyer(@PathVariable int cid, @RequestBody Buyer buyer) {
        int buyerId = buyer.getId();
        Contract contract = contractDao.findById(cid);

        if (contract == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        if (buyerId != 0) {
            Buyer abuyer = buyerDao.findById(buyerId);
            contract.setBuyer(abuyer);
            buyerDao.save(buyer);
            contractDao.save(contract);
            return abuyer;

        }
        contract.setBuyer(buyer);
        buyerDao.save(buyer);
        return buyer;


    }

    @PostMapping("/{cid}/contractor")
    public Contractor addContractor(@PathVariable int cid, @RequestBody Contractor contractor) {
        int contractorId = contractor.getId();
        Contract contract = contractDao.findById(cid);

        if (contract == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        if (contractorId != 0) {
            Contractor acontractor = contractorDao.findById(contractorId);
            contract.setContractor(acontractor);
            contractorDao.save(contractor);
            contractDao.save(contract);
            return acontractor;

        }
        contract.setContractor(contractor);
        contractorDao.save(contractor);
        return contractor;


    }


    @PostMapping("/{cid}/seller")
    public Seller addSeller(@PathVariable int cid, @RequestBody Seller seller) {
        int sellerId = seller.getId();
        Contract contract = contractDao.findById(cid);

        if (contract == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        if (sellerId != 0) {
            Seller aseller = sellerDao.findById(sellerId);
            contract.setSeller(aseller);
            sellerDao.save(seller);
            contractDao.save(contract);
            return aseller;

        }
        contract.setSeller(seller);
        sellerDao.save(seller);
        return seller;


    }

}




