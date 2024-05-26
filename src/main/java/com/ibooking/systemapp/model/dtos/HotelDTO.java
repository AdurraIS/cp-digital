package com.ibooking.systemapp.model.dtos;


import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record HotelDTO(@NotBlank Long id,
                       @NotBlank String nome,
                       @NotBlank int avaliacao,
                       @NotBlank Set<Long> rooms) {
    public HotelDTO(Long id, String nome, int avaliacao, Set<Long> rooms) {
        this.id = id;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.rooms = rooms;
    }
}
