package com.artemzi.data.web.application;

import com.artemzi.data.entity.Room;
import com.artemzi.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {
    private RoomRepository repository;

    @Autowired
    public void getRepository(RoomRepository roomRepository) {
        this.repository = roomRepository;
    }

    @GetMapping(value="/rooms")
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
