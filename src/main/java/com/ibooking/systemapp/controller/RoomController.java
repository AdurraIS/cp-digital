package com.ibooking.systemapp.controller;

import com.ibooking.systemapp.model.dtos.RoomDTO;
import com.ibooking.systemapp.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms(){
        return ResponseEntity.ok(roomService.getAllRoom());
    }
    @GetMapping("/doublebeds/{doublebeds}")
    public ResponseEntity<List<RoomDTO>> getAllByDoubleBeds(int doublebeds){
        return ResponseEntity.ok(roomService.getAllRoomByDoubleBeds(doublebeds));
    }
    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody @Valid RoomDTO data){
        return ResponseEntity.ok(roomService.saveRoom(data));
    }
}
