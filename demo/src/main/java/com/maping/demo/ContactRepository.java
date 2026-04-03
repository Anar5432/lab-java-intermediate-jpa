package com.maping.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import jakarta.persistence.Entity;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * FROM contact WHERE company = ?1", nativeQuery = true)
    List<Contact> findContactsByCompanyNativeSQL (String companyName);
}
