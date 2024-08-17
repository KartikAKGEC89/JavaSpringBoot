package com.embarkx.firstjobapp.company;

import com.embarkx.firstjobapp.job.Job;

import java.util.List;


public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany( Long Id, Company company);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);
}