package com.IronHach.CRM.CRM.Repositories;

import com.IronHach.CRM.CRM.models.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, String> {


    /*@Query("SELECT count(l), s.name FROM Leads l JOIN SalesRep s ON l.leadsListSR = s.id GROUP BY s.name")
    Leads countBySR();

     */
}