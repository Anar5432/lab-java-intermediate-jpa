package com.maping.demo;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class InternalTask extends  Task {
    public InternalTask(){}

    public InternalTask (String title, LocalDate dueDate, Boolean status){
        super (title ,dueDate, status);
    }

}
