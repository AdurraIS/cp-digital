package com.ibooking.systemapp.controller;

import com.ibooking.systemapp.model.dtos.BookingDTO;
import com.ibooking.systemapp.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBooking(){
        return ResponseEntity.ok(bookingService.getAllBooking());
    }
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody @Valid BookingDTO data){
        return ResponseEntity.ok(bookingService.saveBooking(data));
    }
}
