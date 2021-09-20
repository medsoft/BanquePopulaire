package com.medsoft;

import com.medsoft.dao.ClientRepository;
import com.medsoft.dao.CompteRepository;
import com.medsoft.dao.OperationRepository;
import com.medsoft.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BanquePopulaireApplication implements CommandLineRunner {

    @Autowired
    CompteRepository compteRepository ;
    @Autowired
    ClientRepository clientRepository ;
    @Autowired
    OperationRepository operationRepository ;
    public static void main(String[] args) {
        SpringApplication.run(BanquePopulaireApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       /* Client client1  = clientRepository.save(new Client("Mohamed" , "mohamed@gmail.com")) ;
        Client client2  = clientRepository.save(new Client("Omar" , "omar@gmail.com")) ;
        Client client3  = clientRepository.save(new Client("Penda" , "penda@gmail.com")) ;
        Client client4  = clientRepository.save(new Client("Codou" , "codou@gmail.com")) ;
        Client client5  = clientRepository.save(new Client("Julie" , "julie@gmail.com")) ;
        Client client6  = clientRepository.save(new Client("Alex" , "alex@gmail.com")) ;
        Client client7  = clientRepository.save(new Client("Alioune" , "alioune@gmail.com")) ;
        Client client8  = clientRepository.save(new Client("Ahmed" , "ahmed@gmail.com")) ;

        Compte compte1  =  compteRepository.save(new CompteCourant("c001" , new Date(),200000.0 , client1 , 0.0)) ;
        Compte compte2  =  compteRepository.save(new CompteEpargne("c002" , new Date(),320000.0 , client2 , 0.0)) ;
        Compte compte3  =  compteRepository.save(new CompteCourant("c003" , new Date(),105000.0 , client3 , 0.0)) ;
        Compte compte4  =  compteRepository.save(new CompteCourant("c004" , new Date(),2500000.0 , client4 , 0.0)) ;
        Compte compte5  =  compteRepository.save(new CompteCourant("c005" , new Date(),1500000.0 , client5 , 0.0)) ;
        Compte compte6  =  compteRepository.save(new CompteCourant("c006" , new Date(),3500000.0 , client6 , 0.0)) ;
        Compte compte7  =  compteRepository.save(new CompteCourant("c007" , new Date(),5500000.0 , client7 , 0.0)) ;
        Compte compte8  =  compteRepository.save(new CompteCourant("c008" , new Date(),9500000.0 , client8 , 0.0)) ;

        Operation operation1 =  operationRepository.save(new Versement(new Date() , 77600.0 , compte2 ));
        Operation operation2 =  operationRepository.save(new Retrait(new Date() , 90600.0 , compte2 ));
        Operation operation3 =  operationRepository.save(new Retrait(new Date() , 190890.0 , compte4 ));
        Operation operation4 =  operationRepository.save(new Retrait(new Date() , 50640.0 , compte4 ));
        Operation operation5 =  operationRepository.save(new Versement(new Date() , 200000.0 , compte1 ));
        Operation operation6 =  operationRepository.save(new Versement(new Date() , 100000.0 , compte3 ));
        Operation operation7 =  operationRepository.save(new Versement(new Date() , 200400.0 , compte1 ));
        Operation operation8 =  operationRepository.save(new Versement(new Date() , 560000.0 , compte7 ));
        Operation operation9 =  operationRepository.save(new Versement(new Date() , 800000.0 , compte3 ));
        Operation operation10 =  operationRepository.save(new Versement(new Date() , 107000.0 , compte5 ));*/


    }
}
