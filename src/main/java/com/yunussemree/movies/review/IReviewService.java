package com.yunussemree.movies.review;

public interface IReviewService {
    public Review createReview(String reviewBody, String imdbId);
}
