package pan.edu.hotel.controller.rest;
/*
 * @author Alexander Panyshchev
 * @since 13.08.2020
 * @version 1.0
 *Task: create REST controller for client model
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pan.edu.hotel.model.Client;
import pan.edu.hotel.model.Room;
import pan.edu.hotel.service.room.impls.RoomServiceImpl;

import java.util.List;

@RequestMapping("/api/room/v2")
@RestController
public class RoomRestController {
    @Autowired
    RoomServiceImpl roomService;

    @RequestMapping(value = "/", method = RequestMethod.GET)//get List
    List<Room> getRooms(){
        return roomService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)//create
    Room createRoom(@RequestBody Room room){
        return roomService.create(room);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)//update
    Room updateRoom(@RequestBody Room room){
        return roomService.update(room);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//get by id
    Room getRoomById(@PathVariable("id")String id){
        return roomService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//delete
    Room deleteRoom(@PathVariable("id") String id){
        return roomService.delete(id);
    }

}
