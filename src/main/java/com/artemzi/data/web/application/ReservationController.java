package com.artemzi.data.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

    @GetMapping
    public String getReservations() {
        return "reservations";
    }

}
