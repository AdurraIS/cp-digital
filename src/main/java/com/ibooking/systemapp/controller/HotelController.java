package com.ibooking.systemapp.controller;

import com.ibooking.systemapp.model.dtos.HotelDTO;
import com.ibooking.systemapp.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }
    @GetMapping("/{nome}")
    public ResponseEntity<HotelDTO> getHotelByNome(String nome){
        return ResponseEntity.ok(hotelService.getHotelByNome(nome));
    }
    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody @Valid HotelDTO data){
        return ResponseEntity.ok(hotelService.saveHotel(data));
    }
}
