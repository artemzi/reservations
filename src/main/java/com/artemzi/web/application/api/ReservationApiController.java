package com.artemzi.web.application.api;

import com.artemzi.data.entity.Room;
import com.artemzi.data.repository.RoomRepository;
import com.artemzi.domains.RoomReservation;
import com.artemzi.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ReservationApiController {
    private ReservationService reservationService;
    private RoomRepository repository;

    @Autowired
    public void getRepository(RoomRepository roomRepository) {
        this.repository = roomRepository;
    }

    @Autowired
    public void getReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservations/{date}")
    public List<RoomReservation> getAllReservationsForDate(@PathVariable(value = "date") String dateString) {
        return this.reservationService.getRoomReservationsForDate(dateString);
    }

    @GetMapping(value="/rooms") // TODO refactor method with service
    List<Room> findAll(@RequestParam(required=false) String roomNumber){
        List<Room> rooms = new ArrayList<>();
        if(null==roomNumber){
            Iterable<Room> results = this.repository.findAll();
            results.forEach(rooms::add);
        }else{
            Room room = this.repository.findByRoomNumber(roomNumber);
            if(null!=room) {
                rooms.add(room);
            }
        }
        return rooms;
    }
}
