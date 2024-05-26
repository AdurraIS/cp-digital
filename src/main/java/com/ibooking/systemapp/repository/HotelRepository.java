package com.ibooking.systemapp.repository;

import com.ibooking.systemapp.model.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Hotel findByNome(String nome);
}
