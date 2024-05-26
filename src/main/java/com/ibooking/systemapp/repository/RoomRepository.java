package com.ibooking.systemapp.repository;

import com.ibooking.systemapp.model.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room> findAllByTotalDoubleBeds(int totalDoubleBeds);

}
