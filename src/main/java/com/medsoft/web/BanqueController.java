package com.medsoft.web;

import com.medsoft.dao.IBanqueMetier;
import com.medsoft.entities.Compte;
import com.medsoft.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BanqueController {
    @Autowired
    private IBanqueMetier banqueMetier ;
    @RequestMapping(value ="/operations")
    public String index ()
    {
        return "comptes" ;
    }
    @RequestMapping(value ="/consulterCompte")
    public String consulter (Model model , String codeCompte) {
        model.addAttribute("codeCompte", codeCompte);
        {
            try {
                Compte compte = banqueMetier.consulterCompte(codeCompte);
                Page<Operation> pageOperations = banqueMetier.listOperation(codeCompte , 0 ,4) ;
                model.addAttribute("listoperations" , pageOperations.getContent());
                model.addAttribute("compte", compte);
            } catch (Exception e) {
                model.addAttribute("exception");
            }
            return "comptes";
        }

    }
    @RequestMapping(value = "/saveOperation",method = RequestMethod.POST)
    public String saveOperation (Model model ,  String typeOperation , String codeCompte , String codeCompte2, double montant) {
        String message = "Operation reussie " ;
        try{
        if (typeOperation.equals("VERS")){
            banqueMetier.verser(codeCompte ,  montant);
        }else if (typeOperation.equals("RETR")) {
            banqueMetier.retirer(codeCompte , montant);
        }else if (typeOperation.equals("VIR")){
            banqueMetier.virement(codeCompte , codeCompte2 , montant);
            return "redirect:/consulterCompte?codeCompte="+codeCompte+"&message="+message ;
        }

    }catch(Exception error ){
        model.addAttribute("error", error ) ;
        return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+error.getMessage() ;
    }
        return "redirect:/consulterCompte?codeCompte="+codeCompte ;
    }
}

