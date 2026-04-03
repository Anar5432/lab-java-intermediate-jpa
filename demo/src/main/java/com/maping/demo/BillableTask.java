package com.maping.demo;
import jakarta.persistence.*;
import com.maping.demo.Task;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class BillableTask extends Task{

    @Column(nullable=false)
    private Double  hourlyRate;

    public BillableTask () {};

    public BillableTask(String title, LocalDate dueDate, Boolean status, Double hourlyRate){
        super(title, dueDate, status);


        this.hourlyRate=hourlyRate;
    }


    public Double getHourlyRate (){
        return hourlyRate;
    }
    public void setHourlyRate (Double hourlyRate){
        this.hourlyRate=hourlyRate;
    }
}