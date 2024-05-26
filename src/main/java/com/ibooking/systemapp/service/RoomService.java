package com.ibooking.systemapp.service;

import com.ibooking.systemapp.exceptions.BookingNotFoundException;
import com.ibooking.systemapp.exceptions.HotelNotFoundException;
import com.ibooking.systemapp.exceptions.RoomNotFoundException;
import com.ibooking.systemapp.model.dtos.RoomDTO;
import com.ibooking.systemapp.model.entities.Booking;
import com.ibooking.systemapp.model.entities.Room;
import com.ibooking.systemapp.repository.BookingRepository;
import com.ibooking.systemapp.repository.HotelRepository;
import com.ibooking.systemapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository,
                       BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.bookingRepository = bookingRepository;
    }
    public RoomDTO saveRoom(RoomDTO data){
        Room room = new Room();
        return objectToDto(roomRepository.save(dtoToObject(room,data)));
    }
    public List<RoomDTO> getAllRoom(){
        return roomRepository.findAll().stream().map(this::objectToDto).toList();
    }
    public List<RoomDTO> getAllRoomByDoubleBeds(int doubleBeds){
        return roomRepository.findAllByTotalDoubleBeds(doubleBeds).stream().map(this::objectToDto).toList();
    }
    public Room dtoToObject(Room room,RoomDTO data){
        room.setId(data.id());
        room.setHotel(hotelRepository.findById(data.hotel()).orElseThrow(RoomNotFoundException::new));
        room.setDailyRate(data.dailyRate());
        Set<Booking> dates = new HashSet<>();
        for(Long id: data.bookedDates()){
            dates.add(bookingRepository.findById(id).orElseThrow(BookingNotFoundException::new));
        }
        room.setBookedDates(dates);
        room.setTotalSingleBeds(data.totalSingleBeds());
        room.setTotalDoubleBeds(data.totalDoubleBeds());
        return room;
    }
    public RoomDTO objectToDto(Room data){
        Set<Long> bookings = new HashSet<>();
        for(Booking booking: data.getBookedDates()){
            bookings.add(booking.getId());
        }
        return new RoomDTO(data.getId(),
                data.getHotel().getId(),
                data.getTotalDoubleBeds(),
                data.getTotalSingleBeds(),
                bookings,
                data.getDailyRate());
    }
}
