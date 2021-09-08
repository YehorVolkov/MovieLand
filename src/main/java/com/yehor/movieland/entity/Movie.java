package com.yehor.movieland.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    private LocalDate yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
}
