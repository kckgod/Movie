package kr.ac.mjc.movie.dto;

import kr.ac.mjc.movie.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddReviewRequest {

    private String content;

    public Review toEntity() {
        Review reviews = new Review(content);
        return reviews;
    }
}
