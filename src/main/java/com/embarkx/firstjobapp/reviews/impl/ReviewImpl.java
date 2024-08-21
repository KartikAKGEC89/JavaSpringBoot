package com.embarkx.firstjobapp.reviews.impl;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyService;
import com.embarkx.firstjobapp.reviews.Reviews;
import com.embarkx.firstjobapp.reviews.ReviewsRepository;
import com.embarkx.firstjobapp.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;
    private final CompanyService companyService;

    public ReviewImpl(ReviewsRepository reviewsRepository, CompanyService companyService) {
        this.reviewsRepository = reviewsRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Reviews> getReviews(Long companyId) {
        List<Reviews> reviews;
        reviews = reviewsRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void createReview(Long companyId, Reviews review) {
        int company = companyService.getCompanyById(companyId);

        if(company> 0) {
            reviewsRepository.save(review);
        }
    }
}
