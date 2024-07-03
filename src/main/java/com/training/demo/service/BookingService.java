package com.training.demo.service;

import com.training.demo.model.BookShow;
import com.training.demo.model.Movie;
import com.training.demo.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    @Autowired
    private MovieService movieService;

    public List<BookShow> getBookings(){
        return bookingRepository.findAll();
    }

    public BookShow getShowDetail(String bookingId){
        return bookingRepository.getShowDetailByBookingId(bookingId);
    }

    public BookShow createBooking(BookShow request){
        long seed = System.currentTimeMillis();
        Random rng = new Random(seed);
        rng.nextLong();
        Movie movie = movieService.getMovie(request.getMovie());
        BookShow.builder().name(request.getName()).bookingId(String.valueOf(rng.nextLong())).city(request.getCity()).showDate(request.getShowDate())
                .bookingDate(new Date()).movie(request.getMovie()).theatre(request.getTheatre()).movieSlot(request.getMovieSlot()).build();
        return movie!=null?bookingRepository.save(request):BookShow.builder().name("Booking Failed").build();
    }

    public void deleteBooking(String bookingId){
        BookShow bookShow = bookingRepository.getShowDetailByBookingId(bookingId);
        bookingRepository.deleteById(bookShow.getId());
    }
}
