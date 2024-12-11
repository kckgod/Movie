package kr.ac.mjc.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieRequest {

    private String name;

    private String director;

    private String actor;

    private String type;

    private String time;

    private String releaseDate;

    private String imageUrl;

    private String story;
}
