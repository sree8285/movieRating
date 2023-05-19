package com.example.Movies.Review.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
public class MovieDto
{
    private String movieName;
    private Date releaseDate;
    private String musicDirector;
    private String ottPlatForm;

}
