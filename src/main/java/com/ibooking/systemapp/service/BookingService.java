package com.ibooking.systemapp.service;

import com.ibooking.systemapp.exceptions.RoomNotFoundException;
import com.ibooking.systemapp.model.dtos.BookingDTO;
import com.ibooking.systemapp.model.entities.Booking;
import com.ibooking.systemapp.repository.BookingRepository;
import com.ibooking.systemapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }
    public BookingDTO saveBooking(BookingDTO data){
        Booking booking = new Booking();
        return objectToDto(bookingRepository.save(dtoToObject(booking,data)));
    }
    public List<BookingDTO> getAllBooking(){
        return bookingRepository.findAll().stream().map(this::objectToDto).toList();
    }
    public Booking dtoToObject(Booking booking,BookingDTO data){
        booking.setRoom(roomRepository.findById(data.id()).orElseThrow(RoomNotFoundException::new));
        booking.setTotalCost(data.totalCost());
        booking.setTotalDays(data.totalDays());
        booking.setBookedDate(data.bookedDate());
        return booking;
    }
    public BookingDTO objectToDto(Booking data){
        return new BookingDTO(data.getRoom().getId(),
                data.getBookedDate(),
                data.getTotalCost(),
                data.getTotalDays(),
                data.getId());
    }
}
