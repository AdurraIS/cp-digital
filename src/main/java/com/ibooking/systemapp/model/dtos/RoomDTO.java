package com.ibooking.systemapp.model.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record RoomDTO( @NotBlank Long id,
                       @NotBlank Long hotel,
                       @NotBlank int totalDoubleBeds,
                       @NotBlank int totalSingleBeds,
                       @NotBlank Set<Long> bookedDates,
                       @NotBlank Double dailyRate) {
    public RoomDTO(Long id, Long hotel, int totalDoubleBeds, int totalSingleBeds, Set<Long> bookedDates, Double dailyRate) {
        this.id = id;
        this.hotel = hotel;
        this.totalDoubleBeds = totalDoubleBeds;
        this.totalSingleBeds = totalSingleBeds;
        this.bookedDates = bookedDates;
        this.dailyRate = dailyRate;
    }
}
