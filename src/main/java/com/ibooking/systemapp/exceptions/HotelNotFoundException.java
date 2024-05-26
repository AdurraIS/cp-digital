package com.ibooking.systemapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class HotelNotFoundException extends BookingException{


    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle("Hotel Not Found");
        return pb;
    }
}
