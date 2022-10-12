package com.IronHach.CRM.CRM;

import com.IronHach.CRM.CRM.Repositories.LeadsRepository;
import com.IronHach.CRM.CRM.Repositories.SalesRepRepository;
import com.IronHach.CRM.CRM.enums.Product;
import com.IronHach.CRM.CRM.enums.Status;
import com.IronHach.CRM.CRM.models.Leads;
import com.IronHach.CRM.CRM.models.Opportunity;
import com.IronHach.CRM.CRM.models.SalesRep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LeadsTest {

    @Autowired
    LeadsRepository leadsRepository;

    @Autowired
    SalesRepRepository salesRepRepository;


    Leads lds;
    @BeforeEach
    void setUp() {

        lds = leadsRepository.save(
                new Leads("Juan Ber", "74855", "10@gmaqil.com", "LOL")

        );
    }
   /* @Test
    void countBySR(){
        SalesRep sr = salesRepRepository.save(new SalesRep("Pol"));
        Leads lds1 = leadsRepository.save(new Leads(sr));
        Leads leadsOptional = leadsRepository.countBySR();
        Assertions.assertTrue(leadsOptional.equals("Pol"));

    };*/
}
