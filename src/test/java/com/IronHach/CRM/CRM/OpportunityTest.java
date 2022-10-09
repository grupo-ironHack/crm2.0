package com.IronHach.CRM.CRM;

import com.IronHach.CRM.CRM.Repositories.OpportunityRepository;
import com.IronHach.CRM.CRM.enums.Product;
import com.IronHach.CRM.CRM.enums.Status;
import com.IronHach.CRM.CRM.models.Opportunity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OpportunityTest {

    @Autowired
    OpportunityRepository opportunityRepository;

    List<Opportunity> opps;

    @BeforeEach
    void setUp() {

        opps = opportunityRepository.saveAll(List.of(
                new Opportunity("Pol Ber", Product.BOX, 10, Status.OPEN),
                new Opportunity("Yehosua Dos", Product.BOX, 15, Status.OPEN)


        ));
    }

    @AfterEach
    void tearDown(){
        opportunityRepository.deleteAll();

    }

    //----------- ByProduct:-----------

    @Test
    void countOfAllOppsByProduct(){
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana J", Product.HYBRID, 50, Status.OPEN));
        Optional<Opportunity> opportunityOptional = opportunityRepository.countByProduct(Product.HYBRID);
        Assertions.assertTrue(opportunityOptional.isPresent());

    }

    @Test
    void countAllStatusWonByProduct(){
        Opportunity opps2 = opportunityRepository.save(new Opportunity("Juan Lucas", Product.HYBRID, 40, Status.CLOSED_WON));
        Optional<Opportunity> opportunityOptional = (opportunityRepository.countAllStatusWonByProduct(Status.CLOSED_WON, Product.HYBRID));
        Assertions.assertTrue((opportunityOptional.isPresent()));
    }

    @Test
    void countAllStatusLostByProduct(){
        Opportunity opps3 = opportunityRepository.save(new Opportunity("Juan Andres", Product.BOX, 40, Status.CLOSED_LOST));
        Optional<Opportunity> opportunityOptional = opportunityRepository.countAllStatusLostByProduct(Status.CLOSED_LOST, Product.BOX);
        Assertions.assertTrue((opportunityOptional.isPresent()));
    }

    @Test
    void countAllStatusOpenByProduct(){
        Opportunity opps3 = opportunityRepository.save(new Opportunity("Juan Andres", Product.HYBRID, 40, Status.OPEN));
        Optional<Opportunity> opportunityOptional = opportunityRepository.countAllStatusOpenByProduct(Status.OPEN, Product.HYBRID);
        Assertions.assertTrue((opportunityOptional.isPresent()));
    }

    //----------- ByCountry:-----------

    @Test
    void countByCountry(){ //¿¿¿necessito un contructor del coutnry??
        Opportunity opps1 = opportunityRepository.save(new Opportunity("Diana J", Product.HYBRID, 50, Status.OPEN));
        Optional<Opportunity> opportunityOptional = opportunityRepository.countByCountry("Spain");
        Assertions.assertTrue(opportunityOptional.isPresent());

    }

    @Test
    void countAllStatusWonByCountry_works() {
        List<Object[]> result = opportunityRepository.countAllStatusWonByCountry();
        //Assertions.assertEquals()

    }


}
