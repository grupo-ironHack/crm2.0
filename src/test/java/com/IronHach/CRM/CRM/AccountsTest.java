package com.IronHach.CRM.CRM;

import com.IronHach.CRM.CRM.Repositories.AccountsRepository;
import com.IronHach.CRM.CRM.enums.Industry;
import com.IronHach.CRM.CRM.models.Accounts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AccountsTest {

    @Autowired
    AccountsRepository accountsRepository;

    List<Accounts> ac;
    @BeforeEach
    void setUp() {

        ac = accountsRepository.saveAll(List.of(
                new Accounts(Industry.OTHER, 1, "BCN", "Spain"),
                new Accounts(Industry.OTHER, 19, "BCN", "Spain")
        ));
    }

    @Test
    void findByMaxEmployees(){
        Accounts random = new Accounts(Industry.OTHER, 19, "x", "Spain");
        List<Object[]> accountsOptional = accountsRepository.findByMaxEmployees();
        Assertions.assertTrue(accountsOptional.get(0)[0].equals(19));
    }

    @Test
    void findByMinEmployees(){
        Accounts random = new Accounts(Industry.OTHER, 1, "x", "Spain");
        List<Object[]> accountsOptional1 = accountsRepository.findByMinEmployees();
        Assertions.assertTrue(accountsOptional1.get(0)[0].equals(1));
    }
}
