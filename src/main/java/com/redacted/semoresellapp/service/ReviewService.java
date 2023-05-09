package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.exception.ReviewNotFoundException;
import com.redacted.semoresellapp.model.Order;
import com.redacted.semoresellapp.model.Review;
import com.redacted.semoresellapp.repository.OrderRepository;
import com.redacted.semoresellapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private OrderRepository orderRepository;

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

        Order order = review.getOrder();
        order.setPrice(updatedReview.getOrder().getPrice());
        order.setStatus(updatedReview.getOrder().getStatus());
        order.setQuantity(updatedReview.getOrder().getQuantity());
        order.setSeller(updatedReview.getOrder().getSeller());

        orderRepository.save(order);

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
