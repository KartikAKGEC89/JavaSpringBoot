package com.embarkx.firstjobapp.job;

// Module for job

import com.embarkx.firstjobapp.company.Company;
import jakarta.persistence.*;

//This code defines a Java class named Job in the com.embarkx.firstjobapp.job package.
//The Job class represents a job posting and contains the following fields:
//id (long): A unique identifier for the job posting.
//title (String): The title of the job posting.
//description (String): A description of the job responsibilities and requirements.
//minSalary (String): The minimum salary range for the job.
//maxSalary (String): The maximum salary range for the job.
//location (String): The location where the job is based.
//        The class has a constructor that takes all the fields as parameters and initializes them.
//        It also provides getter and setter methods for each field, allowing access and modification
//        of the field values.
@Entity
//@Table(name = "job_table")
public class Job {

//  JPA Manage the id field. with @Id and @GeneratedValue(strategy = GenerationType.IDENTITY);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String title;
    private  String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    private Company company;

    public Job() {
    }

    public Job(long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
