package com.embarkx.firstjobapp.reviews.impl;

import com.embarkx.firstjobapp.reviews.Reviews;
import com.embarkx.firstjobapp.reviews.ReviewsRepository;
import com.embarkx.firstjobapp.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;

    public ReviewImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public List<Reviews> getReviews(Long companyId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(companyId);
        return reviews;
    }
}
