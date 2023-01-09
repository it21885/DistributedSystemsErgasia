package gr.hua.dit.ergasia.omada28.Controller;

import java.util.List;

import gr.hua.dit.ergasia.omada28.DAO.ContractDao;
import gr.hua.dit.ergasia.omada28.DAO.SellerDao;
import gr.hua.dit.ergasia.omada28.Entity.Buyer;
import gr.hua.dit.ergasia.omada28.Entity.Contract;
import gr.hua.dit.ergasia.omada28.Entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/seller")
public class SellerController {



    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private ContractDao contractDao;

    @GetMapping("")
    public List<Seller> getallSellers(){
        return sellerDao.findall();
    }

    @GetMapping("/{id}")
    public Seller getById(@PathVariable int id){
        return sellerDao.findById(id);
    }

    @PostMapping("")
    public Seller save(@RequestBody Seller seller){
        seller.setId(seller.getId());
        sellerDao.save(seller);
        return seller;
    }

    @GetMapping("/{id}/contract")
    public Contract getContractBySellerId(@PathVariable int id){
        Seller seller = sellerDao.findById(id);
        return seller.getContract();
    }


    @PostMapping("/{id}/contract/agree/{choice}")
    public Contract sellerAgree(@PathVariable("id") int id, @PathVariable("choice") int choice){
        Seller seller = sellerDao.findById(id);


        if(seller == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Contract contract = seller.getContract();

        if(contract == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }


        if (choice == 0){
            contract.setSeller_agree("no");
            contractDao.save(contract);
            return contract;

        } else if (choice == 1){
            contract.setSeller_agree("yes");
            contractDao.save(contract);
            return contract;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please enter a valid choice"
            );
        }


    }






}
