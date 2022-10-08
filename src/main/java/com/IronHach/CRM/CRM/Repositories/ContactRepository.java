package com.IronHach.CRM.CRM.Repositories;

import com.IronHach.CRM.CRM.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
