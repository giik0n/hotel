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
import pan.edu.hotel.form.RoomForm;
import pan.edu.hotel.form.SettlementForm;
import pan.edu.hotel.model.Client;
import pan.edu.hotel.model.Room;
import pan.edu.hotel.model.Settlement;
import pan.edu.hotel.service.client.impls.ClientServiceImpl;
import pan.edu.hotel.service.room.impls.RoomServiceImpl;
import pan.edu.hotel.service.settlement.impls.SettlementServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RequestMapping("/web/settlement")
@Controller
public class SettlementWebController {

    @Autowired
    SettlementServiceImpl settlementService;

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    RoomServiceImpl roomService;

    Map<String,String> clientsMap, roomsMap;


    @PostConstruct
    void init(){
        clientsMap = new HashMap<>();
        for (Client client:clientService.getAll()){
            clientsMap.put(client.getId(),client.getName());
        }

        roomsMap = new HashMap<>();
        for (Room room:roomService.getAll()){
            roomsMap.put(room.getRoomId(),room.getRoomNumber());
        }
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String showAll(Model model){
        List<Settlement> settlementList = settlementService.getAll();
        model.addAttribute("list", settlementList);
        return "settlementList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createSettlement(Model model){
        SettlementForm settlementForm = new SettlementForm();
        model.addAttribute("settlementForm", settlementForm);
        model.addAttribute("clients", clientsMap);
        model.addAttribute("rooms", roomsMap);
        return "addSettlement";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSettlement(Model model, @ModelAttribute("settlementForm") SettlementForm settlementForm){
        Settlement settlement = new Settlement();
        settlement.setClient(settlementForm.getClient());
        settlement.setRoom(settlementForm.getRoom());
        settlement.setCheckInDate(LocalDate.parse(settlementForm.getCheckInDate()));
        settlement.setCheckOutDate(LocalDate.parse(settlementForm.getCheckOutDate()));
        settlement.setComment(settlementForm.getComment());
        settlementService.create(settlement);
        System.out.println("Added new Settlement");

        model.addAttribute("list", settlementService.getAll());
        return "redirect:/web/settlement/get/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateSettlement(@PathVariable("id") String id,Model model) {
        Settlement settlement = settlementService.get(id);
        SettlementForm settlementForm = new SettlementForm(
                settlement.getSettlementId(),
                settlement.getDescription(),
                settlement.getClient(),
                settlement.getRoom(),
                settlement.getCheckInDate().toString(),
                settlement.getCheckOutDate().toString(),
                settlement.getComment()
        );
        model.addAttribute("settlementForm", settlementForm);
        model.addAttribute("clients", clientsMap);
        model.addAttribute("rooms", roomsMap);
        return "addSettlement";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateSettlement(Model model,@PathVariable("id") String id, @ModelAttribute("settlementForm") SettlementForm settlementForm){
        Settlement settlement = new Settlement();
        settlement.setSettlementId(id);
        settlement.setDescription(settlementForm.getDescription());
        settlement.setClient(settlementForm.getClient());
        settlement.setRoom(settlementForm.getRoom());
        settlement.setCheckInDate(LocalDate.parse(settlementForm.getCheckInDate()));
        settlement.setCheckOutDate(LocalDate.parse(settlementForm.getCheckOutDate()));
        settlement.setComment(settlementForm.getComment());
        settlementService.update(settlement);

        model.addAttribute("settlements", settlementService.getAll());
        return "redirect:/web/settlement/get/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteSettlementById(@PathVariable("id") String id, Model model){
        settlementService.delete(id);
        model.addAttribute("list", settlementService.getAll());
        return "redirect:/web/settlement/get/list";
    }


}
