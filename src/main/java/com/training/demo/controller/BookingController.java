package com.training.demo.controller;


import com.training.demo.model.BookShow;
import com.training.demo.service.BookingService;
import com.training.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/{bookingId}")
    public BookShow getBookingDetails(@PathVariable String bookingId) {
        return bookingService.getShowDetail(bookingId);
    }

    @GetMapping()
    public List<BookShow> getAllBookings(){
        return bookingService.getBookings();
    }

    @PostMapping
    public BookShow createBooking(@RequestBody BookShow request){
        return bookingService.createBooking(request);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable String bookingId){
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking Deleted Successfully");

    }
}
