package com.maping.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import jakarta.persistence.Entity;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // This Bean runs automatically when the app starts!
    @Bean
    public CommandLineRunner testMyDatabase(ContactRepository contactRepository) {
        return args -> {
            System.out.println("--- APP STARTED: TESTING DATABASE ---");

            // 1. Create a Name and a Contact
            Name newName = new Name("Bruce", "Wayne", "Thomas", "Mr.");
            Contact newContact = new Contact("CEO", "Wayne Enterprises", newName);

            // 2. Save it using standard JPA
            contactRepository.save(newContact);
            System.out.println("✅ Saved Bruce Wayne to the database!");

            // 3. Test your Native SQL Query!
            System.out.println("🔍 Searching for 'Wayne Enterprises' using Native SQL...");
            List<Contact> searchResults = contactRepository.findContactsByCompanyNativeSQL("Wayne Enterprises");

            // 4. Print the results
            for (Contact contact : searchResults) {
                System.out.println("🎯 FOUND: " + contact.getName().getFirstName() + " at " + contact.getCompany());
            }

            System.out.println("--- TEST COMPLETE ---");
        };
    }
}