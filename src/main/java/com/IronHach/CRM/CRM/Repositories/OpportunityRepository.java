package com.IronHach.CRM.CRM.Repositories;

import com.IronHach.CRM.CRM.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, String> {


    //----------- ByProduct:-----------
    Optional<Opportunity> countByProduct(Enum type);
    Optional<Opportunity> countAllStatusWonByProduct(Enum stats, Enum type);
    Optional<Opportunity> countAllStatusLostByProduct(Enum stats, Enum type);
    Optional<Opportunity> countAllStatusOpenByProduct(Enum stats, Enum type);
        //Si no funciona hacer la sintaxis pura de WorkBench

    //----------- ByCountry:-----------
    Optional<Opportunity> countByCountry(String country);

    @Query("SELECT Opportunity.opportunity_id, Accounts.country FROM Opportunity WHERE status = won, INNER JOIN Accounts ON Opportunity.sales_rep = Account.Sales_rep GROUP BY country")
    List<Object[]> countAllStatusWonByCountry();

    @Query("SELECT Opportunity.opportunity_id, Accounts.country FROM Opportunity WHERE status = lost, INNER JOIN Accounts ON Opportunity.sales_rep = Account.Sales_rep GROUP BY country")
    List<Object[]> countAllStatusLostByCountry();

    @Query("SELECT Opportunity.opportunity_id, Accounts.country FROM Opportunity WHERE status = open, INNER JOIN Accounts ON Opportunity.sales_rep = Account.Sales_rep GROUP BY country")
    List<Object[]> countAllStatusOpenByCountry();



    //----------- ByCity:-----------
    Optional<Opportunity> countByCity(String city);

    @Query("SELECT Opportunity.opportunity_id, Accounts.city FROM Opportunity WHERE status = won, INNER JOIN Accounts ON Opportunity.sales_rep = Account.Sales_rep GROUP BY city")
    List<Object[]> countAllStatusWonByCity();

    @Query("SELECT Opportunity.opportunity_id, Accounts.city FROM Opportunity WHERE status = lost, INNER JOIN Accounts ON Opportunity.sales_rep = Account.Sales_rep GROUP BY city")
    List<Object[]> countAllStatusLostByCity();

    @Query("SELECT Opportunity.opportunity_id, Accounts.city FROM Opportunity WHERE status = open, INNER JOIN Accounts ON Opportunity.sales_rep = Account.Sales_rep GROUP BY city")
    List<Object[]> countAllStatusOpenByCity();

    //----------- ByIndustry:-----------


    //----------- ByProduct:-----------
}
