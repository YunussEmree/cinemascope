package com.yunussemree.movies.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.api.ApiResponse;

import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    IReviewService reviewService;

    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createReview (@RequestBody Map<String, String> payload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Review created", reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))));
    }
}
