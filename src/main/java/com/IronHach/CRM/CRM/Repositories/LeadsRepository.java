package com.IronHach.CRM.CRM.Repositories;

import com.IronHach.CRM.CRM.models.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, String> {
}
