package com.IronHach.CRM.CRM.Repositories;

import com.IronHach.CRM.CRM.models.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, String> {



    @Query("SELECT max(a.numEmployees) FROM Accounts a")
    List<Object[]> findByMaxEmployees();

    @Query("SELECT min(a.numEmployees) FROM Accounts a")
    List<Object[]> findByMinEmployees();




}


// SQL
/*
@Query("SELECT MIN (num_employees) FROM Accounts";
@Query("SELECT MAX (num_employees) FROM Accounts";
@Query("SELECT AVG(num_employees) as 'median' FROM Accounts;
@Query("SELECT AVG(num_employees) ad 'median' FROM(SELECT  @row:=@row+1 AS row )
 */