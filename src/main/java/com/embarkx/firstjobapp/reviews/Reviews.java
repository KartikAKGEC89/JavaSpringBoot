package com.embarkx.firstjobapp.reviews;

import com.embarkx.firstjobapp.company.Company;
import jakarta.persistence.*;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String description;
    private double rating;

    @ManyToOne
    private Company company;

    public Reviews() {
    }

//    public Reviews(Long id, String tittle, String description, double rating) {
//        this.id = id;
//        this.tittle = tittle;
//        this.description = description;
//        this.rating = rating;
//    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
