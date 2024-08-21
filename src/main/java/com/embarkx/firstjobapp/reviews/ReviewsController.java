package com.embarkx.firstjobapp.reviews;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {
    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewsService.getReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String>createReview(@PathVariable Long companyId, @RequestBody Reviews review) {
        reviewsService.createReview(companyId, review);
        return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
    }
}
