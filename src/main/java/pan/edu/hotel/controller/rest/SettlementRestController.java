package pan.edu.hotel.controller.rest;
/*
 * @author Alexander Panyshchev
 * @since 13.08.2020
 * @version 1.0
 *Task: create REST controller for client model
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pan.edu.hotel.model.Room;
import pan.edu.hotel.model.Settlement;
import pan.edu.hotel.service.settlement.impls.SettlementServiceImpl;

import java.util.List;

@RequestMapping("/api/settlement/v2")
@RestController
public class SettlementRestController {
    @Autowired
    SettlementServiceImpl settlementService;

    @RequestMapping(value = "/", method = RequestMethod.GET)//get List
    List<Settlement> getSettlements(){
        return settlementService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)//create
    Settlement createSettlement(@RequestBody Settlement settlement){
        return settlementService.create(settlement);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)//update
    Settlement updateSettlement(@RequestBody Settlement settlement){
        return settlementService.update(settlement);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//get by id
    Settlement getSettlementById(@PathVariable("id")String id){
        return settlementService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//delete
    Settlement deleteSettlement(@PathVariable("id") String id){
        return settlementService.delete(id);
    }

}
