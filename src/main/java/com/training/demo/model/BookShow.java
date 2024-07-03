package com.training.demo.model;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@Document(collection = "booking")
public class BookShow {

    private ObjectId id;
    private String bookingId;
    private String name;
    private String movie;
    private Date showDate;
    private Date bookingDate;
    private String movieSlot;
    private String theatre;
    private String city;
}
