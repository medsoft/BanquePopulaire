package com.medsoft.dao;

import com.medsoft.entities.Compte;
import com.medsoft.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
    public Compte consulterCompte (String codeCpte) ;
    public void verser (String codeCpte , double montant) ;
    public void retirer (String codeCpte , double montant) ;
    public void virement (String codeCpte1 , String codeCpte2 , double montant) ;
    public Page<Operation> listOperation (String codeCpte , int page  ,  int size );
}
