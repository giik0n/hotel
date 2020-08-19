package pan.edu.hotel.controller.web;
/*
 * @author Alexander Panyshchev
 * @since 13.08.2020
 * @version 1.0
 *Task: create web controller for client model
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pan.edu.hotel.form.ClientForm;
import pan.edu.hotel.form.RoomForm;
import pan.edu.hotel.model.Client;
import pan.edu.hotel.model.Room;
import pan.edu.hotel.service.room.impls.RoomServiceImpl;

@RequestMapping("/web/room")
@Controller
public class RoomWebController {

    @Autowired
    RoomServiceImpl roomService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String showAll(Model model){
        model.addAttribute("list", roomService.getAll());
        return "roomList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createRoom(Model model){
        RoomForm roomForm = new RoomForm();
        model.addAttribute("roomForm", roomForm);
        return "addRoom";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRoom(Model model, @ModelAttribute("roomForm") RoomForm roomForm){
        Room room = new Room();
        room.setRoomNumber(roomForm.getRoomNumber());
        room.setRoomCapacity(roomForm.getRoomCapacity());
        room.setComfort(roomForm.getComfort());
        room.setPrice(roomForm.getPrice());
        roomService.create(room);

        model.addAttribute("rooms", roomService.getAll());
        return "redirect:/web/room/get/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateRoom(@PathVariable("id") String id,Model model) {
        Room room = roomService.get(id);
        RoomForm roomForm = new RoomForm(
                room.getRoomId(),
                room.getDescription(),
                room.getRoomNumber(),
                room.getRoomCapacity(),
                room.getComfort(),
                room.getPrice()
        );
        model.addAttribute("roomForm", roomForm);
        return "addRoom";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateRoom(Model model,@PathVariable("id") String id, @ModelAttribute("roomForm") RoomForm roomForm){
        Room room = new Room();
        room.setRoomId(id);
        room.setDescription(roomForm.getDescription());
        room.setRoomNumber(roomForm.getRoomNumber());
        room.setRoomCapacity(roomForm.getRoomCapacity());
        room.setComfort(roomForm.getComfort());
        room.setPrice(roomForm.getPrice());
        roomService.update(room);

        model.addAttribute("rooms", roomService.getAll());
        return "redirect:/web/room/get/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteRoomById(@PathVariable("id") String id, Model model){
        roomService.delete(id);
        model.addAttribute("list", roomService.getAll());
        return "redirect:/web/room/get/list";
    }


}
