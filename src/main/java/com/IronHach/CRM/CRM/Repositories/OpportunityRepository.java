package com.IronHach.CRM.CRM.Repositories;

import com.IronHach.CRM.CRM.enums.Product;
import com.IronHach.CRM.CRM.enums.Status;
import com.IronHach.CRM.CRM.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, String> {


     //----------- BySR:-----------

    @Query("SELECT count(o), a.name FROM Opportunity o JOIN SalesRep a ON o.opportunityListSR = a.id GROUP BY a.name")
    List<Object[]> countBySR();

    @Query("SELECT count(o), o.status, a.name FROM Opportunity o JOIN SalesRep a  ON o.opportunityListSR = a.id WHERE o.status = '1' GROUP BY a.name")
    List<Object[]> countSrByStatusWon();

    @Query("SELECT count(o), o.status, a.name FROM Opportunity o JOIN SalesRep a  ON o.opportunityListSR = a.id WHERE o.status = '2' GROUP BY a.name")
    List<Object[]> countSrByStatusLost();

    @Query("SELECT count(o), o.status, a.name FROM Opportunity o JOIN SalesRep a  ON o.opportunityListSR = a.id WHERE o.status = '0' GROUP BY a.name")
    List<Object[]> countSrByStatusOpen();


    //----------- ByProduct:-----------

    @Query("SELECT count(o), o.product FROM Opportunity o GROUP BY  o.product")
    List<Object[]> countByProduct();

    @Query(value = "SELECT count(o), o.product FROM Opportunity o WHERE o.status = '1' GROUP BY  o.product")
   List<Object[]> countProductByStatusWon();
    @Query(value = "SELECT count(o), o.product FROM Opportunity o WHERE o.status = '2' GROUP BY  o.product")
    List<Object[]> countProductByStatusLost();
    @Query(value = "SELECT count(o), o.product FROM Opportunity o WHERE o.status = '0' GROUP BY  o.product")
    List<Object[]> countProductByStatusOpen();


    //----------- ByCountry:-----------

   @Query("SELECT count(o), a.country FROM Opportunity o JOIN Accounts a ON o.accountsOpps = a.id GROUP BY a.country")
   List<Object[]> findByAccountsOppsCountry();

    @Query("SELECT count(o), o.status, a.country FROM Opportunity o JOIN Accounts a  ON o.accountsOpps = a.id WHERE o.status = '1' GROUP BY a.country")
    List<Object[]> findByAccountsOppsCountryStatsWon();

    @Query("SELECT count(o), o.status, a.country FROM Opportunity o JOIN Accounts a  ON  o.accountsOpps = a.id WHERE o.status = '2' GROUP BY a.country")
    List<Object[]> findByAccountsOppsCountryStatsLost();

    @Query("SELECT count(o), o.status, a.country FROM Opportunity o JOIN Accounts a  ON o.accountsOpps = a.id WHERE o.status = '0' GROUP BY a.country")
    List<Object[]> findByAccountsOppsCountryStatsOpen();



    //----------- ByCity:-----------
    @Query("SELECT count(o), a.city FROM Opportunity o JOIN Accounts a ON o.accountsOpps = a.id GROUP BY a.city")
    List<Object[]> findByAccountsOppsCity();

    @Query("SELECT count(o), o.status, a.city FROM Opportunity o JOIN Accounts a  ON o.accountsOpps = a.id WHERE o.status = '1' GROUP BY a.city")
    List<Object[]> findByAccountsOppsCityStatsWon();

    @Query("SELECT count(o), o.status, a.city FROM Opportunity o JOIN Accounts a  ON  o.accountsOpps = a.id WHERE o.status = '2' GROUP BY a.city")
    List<Object[]> findByAccountsOppsCityStatsLost();

    @Query("SELECT count(o), o.status, a.city FROM Opportunity o JOIN Accounts a  ON o.accountsOpps = a.id WHERE o.status = '0' GROUP BY a.city")
    List<Object[]> findByAccountsOppsCityStatsOpen();


    //----------- ByIndustry:-----------

    @Query("SELECT count(o), a.industry FROM Opportunity o JOIN Accounts a ON o.accountsOpps = a.id GROUP BY a.industry")
    List<Object[]> findByAccountsOppsIndustry();

    @Query("SELECT count(o), o.status, a.industry FROM Opportunity o JOIN Accounts a  ON o.accountsOpps = a.id WHERE o.status = '1' GROUP BY a.industry")
    List<Object[]> findByAccountsOppsIndustryStatsWon();

    @Query("SELECT count(o), o.status, a.industry FROM Opportunity o JOIN Accounts a  ON  o.accountsOpps = a.id WHERE o.status = '2' GROUP BY a.industry")
    List<Object[]> findByAccountsOppsIndustryStatsLost();

    @Query("SELECT count(o), o.status, a.industry FROM Opportunity o JOIN Accounts a  ON o.accountsOpps = a.id WHERE o.status = '0' GROUP BY a.industry")
    List<Object[]> findByAccountsOppsIndustryStatsOpen();


    //----------- ByProduct:-----------
}
