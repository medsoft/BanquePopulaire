package com.medsoft.dao;

import com.medsoft.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class BanqueMetierImpl  implements IBanqueMetier{
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String codeCpte) {
        Compte compte = compteRepository.getById(codeCpte);
        if (compte == null)
            throw new RuntimeException("Compte Introuvable") ;
        return compte;
    }
    @Override
    public void verser(String codeCpte, double montant) {
        Compte compte =  consulterCompte(codeCpte) ;
        Versement versement =  new Versement(new Date() , montant , compte) ;
        operationRepository.save(versement) ;
        compte.setSolde(compte.getSolde() + montant);
        compteRepository.save(compte) ;
    }
    @Override
    public void retirer(String codeCpte, double montant) {
        Compte compte = consulterCompte(codeCpte) ;
        double faciliteCaisse  =  0  ;
        if (compte instanceof CompteCourant)
            faciliteCaisse =   ((CompteCourant) compte).getDecouvert() ;
        if (compte.getSolde() + faciliteCaisse < montant )
            throw  new RuntimeException("Le solde de votre compte est insuffisant") ;
        Retrait retrait =  new Retrait(new Date() ,  montant ,  compte) ;
        operationRepository.save(retrait) ;
        compte.setSolde(compte.getSolde() - montant) ;
        compteRepository.save(compte);
    }

    @Override
    public void virement(String codeCpte1, String codeCpte2, double montant) {
           if (codeCpte1.equals(codeCpte2))
               throw new RuntimeException("Impossible d'effectuer un virement sur le meme compte") ;
            retirer(codeCpte1 , montant );
            verser(codeCpte2 , montant);

    }

    @Override
    public Page<Operation> listOperation(String codeCpte, int page, int size) {
        return operationRepository.listOperation(codeCpte ,  PageRequest.of(page, size));
    }
}
