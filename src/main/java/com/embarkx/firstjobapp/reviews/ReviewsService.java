package com.embarkx.firstjobapp.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getReviews(Long companyId);
}
