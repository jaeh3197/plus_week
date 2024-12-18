package com.example.demo.dto;

import com.example.demo.entity.ReservationStatus;
import lombok.Getter;

@Getter
public class ReservationUpdateDto {

    private final ReservationStatus status;

    public ReservationUpdateDto(ReservationStatus status) {
        this.status = status;
    }
}
