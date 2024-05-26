package com.ibooking.systemapp.model.dtos;


import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record BookingDTO(@NotBlank Long room, @NotBlank Date bookedDate,
                         @NotBlank Double totalCost, @NotBlank int totalDays, @NotBlank Long id) {

    public BookingDTO(Long room, Date bookedDate, Double totalCost, int totalDays, Long id) {
        this.room = room;
        this.bookedDate = bookedDate;
        this.totalCost = totalCost;
        this.totalDays = totalDays;
        this.id = id;
    }
}
