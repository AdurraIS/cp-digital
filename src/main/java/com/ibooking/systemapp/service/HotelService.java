package com.ibooking.systemapp.service;

import com.ibooking.systemapp.exceptions.RoomNotFoundException;
import com.ibooking.systemapp.model.dtos.HotelDTO;
import com.ibooking.systemapp.model.entities.Hotel;
import com.ibooking.systemapp.model.entities.Room;
import com.ibooking.systemapp.repository.HotelRepository;
import com.ibooking.systemapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }
    public HotelDTO saveHotel(HotelDTO data){
        Hotel hotel = new Hotel();
        return objectToDto(hotelRepository.save(dtoToObject(hotel,data)));
    }
    public HotelDTO getHotelByNome(String nome){
        return objectToDto(hotelRepository.findByNome(nome));
    }
    public List<HotelDTO> getAllHotel(){
        return hotelRepository.findAll().stream().map(this::objectToDto).toList();
    }
    public Hotel dtoToObject(Hotel hotel,HotelDTO data){
        hotel.setId(data.id());
        hotel.setNome(data.nome());
        hotel.setAvaliacao(data.avaliacao());
        Set<Room> rooms = new HashSet<>();
        for (Long roomId : data.rooms()) {
            Room room = roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);
            rooms.add(room);
        }
        hotel.setRooms(rooms);
        return hotel;
    }
    public HotelDTO objectToDto(Hotel data){
        Set<Long> rooms = new HashSet<>();
        for(Room room: data.getRooms()){
            rooms.add(room.getId());
        }
        return new HotelDTO(data.getId(),
                data.getNome(),
                data.getAvaliacao(),
                rooms);
    }
}
