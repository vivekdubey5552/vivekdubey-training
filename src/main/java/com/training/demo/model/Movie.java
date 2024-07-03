package com.training.demo.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@Document(collection = "movieshow")
public class Movie {

    private ObjectId id;
    private String name;
    private Integer year;
    private Date releasedOn;
    private String[] stars;
    private String director;
    private String genre;
    private String cbfc;
    private String duration;
    private String production;
    private Float rating;
    private String country;

}
