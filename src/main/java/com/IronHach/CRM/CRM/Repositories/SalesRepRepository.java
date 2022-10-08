package com.IronHach.CRM.CRM.Repositories;

import com.IronHach.CRM.CRM.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, String> {
}
