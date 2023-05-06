package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.model.Review;
import com.redacted.semoresellapp.repository.ListingRepository;
import com.redacted.semoresellapp.repository.ReviewRepository;
import com.redacted.semoresellapp.exception.ReviewNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ListingRepository listingRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent())
            return optionalReview.get();
        else
            throw new ReviewNotFoundException("No Review with id: " + id + " found");
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Review review = getReviewById(id);
        review.setRating(updatedReview.getRating());
        review.setContent(updatedReview.getContent());
        review.setBuyer(updatedReview.getBuyer());
        review.setSeller(updatedReview.getSeller());

        Listing listing = review.getListing();
        listing.setTitle(updatedReview.getListing().getTitle());
        listing.setDesc(updatedReview.getListing().getDesc());
        listing.setImage(updatedReview.getListing().getImage());
        listing.setPrice(updatedReview.getListing().getPrice());

        listingRepository.save(listing);

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
