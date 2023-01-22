package gr.hua.dit.ergasia.omada28.thController;


import gr.hua.dit.ergasia.omada28.DAO.BuyerDao;
import gr.hua.dit.ergasia.omada28.DAO.ContractDao;
import gr.hua.dit.ergasia.omada28.DAO.ContractorDao;
import gr.hua.dit.ergasia.omada28.DAO.SellerDao;
import gr.hua.dit.ergasia.omada28.Entity.Buyer;
import gr.hua.dit.ergasia.omada28.Entity.Contract;
import gr.hua.dit.ergasia.omada28.Entity.Contractor;
import gr.hua.dit.ergasia.omada28.Entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;



@Controller
public class FormController {

    @Autowired
    private BuyerDao buyerDao;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractorDao contractorDao;




    @GetMapping("/")
    public String index(){
        return "index";
    }


    // START OF BUYER CONTROLLERS

    @GetMapping("/buyerform")
    public String showBuyerForm(Model model){
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);
        return "add-buyer";

    }

    @PostMapping(path = "/buyerform")
    public String saveBuyer(@ModelAttribute("buyer") Buyer buyer){
        //buyer.setFirstName("staticName");
        buyerDao.save(buyer);
        return "redirect:/";
    }


    @GetMapping("/buyerlist")
    public String showBuyerList(Model model){
        List<Buyer> buyers = buyerDao.findAll();

        String name;
        Contract contract;

        for(int i = 0; i < buyers.size() ; i++){
            contract = buyers.get(i).getContract();
            if(contract != null) {
                name = contract.getPropertyname();
                buyers.get(i).setPropertyName(name);
            }
        }

        model.addAttribute("buyers", buyers);
        return "list-buyers";
    }

    // END OF BUYER CONTROLLERS


    // START OF SELLER CONTROLLERS


    @GetMapping("/sellerform")
    public String showSellerForm(Model model){
        Seller seller = new Seller();
        model.addAttribute("seller", seller);
        return "add-seller";

    }

    @PostMapping(path = "/sellerform")
    public String saveSeller(@ModelAttribute("seller") Seller seller){
        //buyer.setFirstName("staticName");
        sellerDao.save(seller);
        return "redirect:/";
    }


    @GetMapping("/sellerlist")
    public String showSellerList(Model model){
        List<Seller> sellers = sellerDao.findall();

        String name;
        Contract contract;

        for(int i = 0; i < sellers.size() ; i++){
            contract = sellers.get(i).getContract();
            if(contract != null) {
                name = contract.getPropertyname();
                sellers.get(i).setPropertyName(name);
            }
        }

        model.addAttribute("sellers", sellers);
        return "list-sellers";
    }



    // END OF SELLER CONTROLLERS


    // START OF CONTRACTOR CONTROLLERS



    @GetMapping("/contractorform")
    public String showContractorForm(Model model){
        Contractor contractor = new Contractor();
        model.addAttribute("contractor", contractor);
        return "add-contractor";

    }

    @PostMapping(path = "/contractorform")
    public String saveContractor(@ModelAttribute("contractor") Contractor contractor){
        //buyer.setFirstName("staticName");
        contractorDao.save(contractor);
        return "redirect:/";
    }


    @GetMapping("/contractorlist")
    public String showContractorList(Model model){
        List<Contractor> contractors = contractorDao.findall();

        String name;
        Contract contract;

        for(int i = 0; i < contractors.size() ; i++){
            contract = contractors.get(i).getContract();
            if(contract != null) {
                name = contract.getPropertyname();
                contractors.get(i).setPropertyName(name);
            }
        }

        model.addAttribute("contractors", contractors);
        return "list-contractors";
    }


    // END OF CONTRACTOR CONTROLLERS



    // START OF CONTRACT CONTROLLERS


    @GetMapping("/contractform")
    public String showContractForm(Model model){
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "add-contract";

    }

    @PostMapping(path = "/contractform")
    public String saveContract(@ModelAttribute("contract") Contract contract){
        //buyer.setFirstName("staticName");
        contractDao.save(contract);
        return "redirect:/";
    }


    @GetMapping("/contractlist")
    public String showContractList(Model model){
        List<Contract> contracts = contractDao.findAll();

        String buyerEmail;
        String sellerEmail;
        String contractorEmail;

        Buyer buyer;
        Seller seller;
        Contractor contractor;


        for(int i = 0; i < contracts.size(); i++){

            buyer = contracts.get(i).getBuyer();
            seller = contracts.get(i).getSeller();
            contractor = contracts.get(i).getContractor();

            if(buyer != null){
                buyerEmail = buyer.getEmail();
                contracts.get(i).setBuyerEmail(buyerEmail);
            }
            if(seller != null){
                sellerEmail = seller.getEmail();
                contracts.get(i).setSellerEmail(sellerEmail);
            }
            if(contractor != null){
                contractorEmail = contractor.getEmail();
                contracts.get(i).setContractorEmail(contractorEmail);
            }

        }
        model.addAttribute("contracts", contracts);
        return "list-contracts";




    }



    // END OF CONTRACT CONTROLLERS

}
