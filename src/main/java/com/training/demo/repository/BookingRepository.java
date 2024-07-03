package com.training.demo.repository;

import com.training.demo.model.BookShow;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookingRepository extends MongoRepository<BookShow, ObjectId> {

    @Query("{ bookingId : ?0 }")
    BookShow getShowDetailByBookingId(String bookingId);
}
