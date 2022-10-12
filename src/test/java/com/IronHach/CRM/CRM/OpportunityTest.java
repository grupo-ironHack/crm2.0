package com.IronHach.CRM.CRM;

import com.IronHach.CRM.CRM.Repositories.AccountsRepository;
import com.IronHach.CRM.CRM.Repositories.OpportunityRepository;
import com.IronHach.CRM.CRM.Repositories.SalesRepRepository;
import com.IronHach.CRM.CRM.enums.Industry;
import com.IronHach.CRM.CRM.enums.Product;
import com.IronHach.CRM.CRM.enums.Status;
import com.IronHach.CRM.CRM.models.Accounts;
import com.IronHach.CRM.CRM.models.Opportunity;
import com.IronHach.CRM.CRM.models.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.Assert;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OpportunityTest {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    SalesRepRepository salesRepRepeository;

    List<Opportunity> opps;

    @BeforeEach
    void setUp() {

        opps = opportunityRepository.saveAll(List.of(
                new Opportunity("Pol Ber", Product.BOX, 10, Status.CLOSED_WON),
                new Opportunity("Yehosua Dos", Product.BOX, 15, Status.OPEN),
                new Opportunity("Pol Ber", Product.BOX, 10, Status.CLOSED_LOST)



        ));
    }

    @AfterEach
    void tearDown(){
     // opportunityRepository.deleteAll();

    }






    //----------- ByProduct:-----------

    @Test
    void countByProduct(){
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana J", Product.HYBRID, 50, Status.OPEN));
        List<Object[]> opportunityOptional = opportunityRepository.countByProduct();
        Long count = (Long) opportunityOptional.get(1)[0];
        Assertions.assertTrue(count.equals(1L));

    }


    @Test
    void countProductByStatusWon(){
        Opportunity opps2 = opportunityRepository.save(new Opportunity("Juan Lucas", Product.HYBRID, 40, Status.CLOSED_WON));
        List<Object[]> opportunityOptional = opportunityRepository.countProductByStatusWon();
        Long count = (Long) opportunityOptional.get(0)[0];
        //System.err.println(opportunityOptional.get(0)[1]);
       Assertions.assertTrue(count.equals(1L));
    }

    @Test
    void countProductByStatusLost(){
        Opportunity opps2 = opportunityRepository.save(new Opportunity("Juan Lucas", Product.HYBRID, 40, Status.CLOSED_LOST));
        List<Object[]> opportunityOptional = opportunityRepository.countProductByStatusLost();
        Long count = (Long) opportunityOptional.get(0)[0];
        Assertions.assertTrue(count.equals(1L));
    }


    @Test
    void countProductByStatusOpen(){
        Opportunity opps2 = opportunityRepository.save(new Opportunity("Juan Lucas", Product.HYBRID, 40, Status.OPEN));
        List<Object[]> opportunityOptional = opportunityRepository.countProductByStatusOpen();
        Long count = (Long) opportunityOptional.get(0)[0];
        Assertions.assertTrue(count.equals(1L));
    }

    //----------- ByCountry:-----------

    @Test
    void findByAccountsOppsCountry(){
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity(acc1));
        List<Object[]> opportunityOptional = opportunityRepository.findByAccountsOppsCountry();
        Assertions.assertTrue(opportunityOptional.get(0)[1].equals("Spain"));

    }

    @Test
    void findByAccountsOppsCountryStatsWon() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_WON, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsCountryStatsWon();
        Assertions.assertTrue(result.get(0)[2].equals("Spain"));

    }

    @Test
    void countCountryByStatusLost() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_LOST, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsCountryStatsLost();
        Assertions.assertTrue(result.get(0)[2].equals("Spain"));

    }

    @Test
    void countCountryByStatusOpen() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.OPEN, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsCountryStatsOpen();
        Assertions.assertTrue(result.get(0)[2].equals("Spain"));

    }

    //----------- ByCity:-----------

    @Test
    void findByAccountsOppsCity(){
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity(acc1));
        List<Object[]> opportunityOptional = opportunityRepository.findByAccountsOppsCity();
        Assertions.assertTrue(opportunityOptional.get(0)[1].equals("Barcelona"));

    }

    @Test
    void findByAccountsOppsCityStatsWon() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_WON, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsCityStatsWon();
        Assertions.assertTrue(result.get(0)[2].equals("Barcelona"));

    }

    @Test
    void countCityByStatusLost() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_LOST, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsCityStatsLost();
        Assertions.assertTrue(result.get(0)[2].equals("Barcelona"));

    }

    @Test
    void countCityByStatusOpen() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.OPEN, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsCityStatsOpen();
        Assertions.assertTrue(result.get(0)[2].equals("Barcelona"));

    }

    //----------- ByIndustry:-----------

    @Test
    void findByAccountsOppsIndustry(){
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity(acc1));
        List<Object[]> opportunityOptional = opportunityRepository.findByAccountsOppsIndustry();
        Assertions.assertTrue(opportunityOptional.get(0)[1].equals(Industry.OTHER));

    }

    @Test
    void findByAccountsOppsIndustryStatsWon() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_WON, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsIndustryStatsWon();
        Assertions.assertTrue(result.get(0)[2].equals(Industry.OTHER));

    }

    @Test
    void countIndustryByStatusLost() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_LOST, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsIndustryStatsLost();
        Assertions.assertTrue(result.get(0)[2].equals(Industry.OTHER));

    }

    @Test
    void countIndustryByStatusOpen() {
        Accounts acc1 = accountsRepository.save(new Accounts(Industry.OTHER, "Barcelona", "Spain"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.OPEN, acc1));
        List<Object[]> result = opportunityRepository.findByAccountsOppsIndustryStatsOpen();
        Assertions.assertTrue(result.get(0)[2].equals(Industry.OTHER));

    }

    //----------- BySR:-----------

    @Test
    void countBySR(){
        SalesRep sr = salesRepRepeository.save(new SalesRep("Pol"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity(sr));
        List<Object[]> opportunityOptional = opportunityRepository.countBySR();
        Assertions.assertTrue(opportunityOptional.get(0)[1].equals("Pol"));

    }
    @Test
    void countSrByStatusWon(){
        SalesRep sr = salesRepRepeository.save(new SalesRep("Pol"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_WON, sr));
        List<Object[]> result = opportunityRepository.countSrByStatusWon();
        Assertions.assertTrue(result.get(0)[2].equals("Pol"));
    }

    @Test
    void countSrByStatusLost(){
        SalesRep sr = salesRepRepeository.save(new SalesRep("Pol"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.CLOSED_LOST, sr));
        List<Object[]> result = opportunityRepository.countSrByStatusLost();
        Assertions.assertTrue(result.get(0)[2].equals("Pol"));
    }

    @Test
    void countSrByStatusOpen(){
        SalesRep sr = salesRepRepeository.save(new SalesRep("Pol"));
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana", Status.OPEN, sr));
        List<Object[]> result = opportunityRepository.countSrByStatusOpen();
        Assertions.assertTrue(result.get(0)[2].equals("Pol"));
    }

    //----------- ByQuantityProduct:-----------

    @Test
    void findByMaxQuantity(){
        Opportunity random = new Opportunity("Pol Bsaer", Product.BOX, 100, Status.CLOSED_WON);
        List<Object[]> opportunityOptional = opportunityRepository.findByMaxQuantity();
        Assertions.assertTrue(opportunityOptional.get(0)[0].equals(15));
    }

    @Test
    void findByMinQuantity(){
        Opportunity random = new Opportunity("Pol Bsdfer", Product.BOX, 10, Status.CLOSED_WON);
        List<Object[]> opportunityOptional = opportunityRepository.findByMinQuantity();
        Assertions.assertTrue(opportunityOptional.get(0)[0].equals(10));
    }


}
