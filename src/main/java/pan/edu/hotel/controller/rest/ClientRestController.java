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
import pan.edu.hotel.service.client.impls.ClientServiceImpl;

import java.util.List;

@RequestMapping("/api/client/v2")
@RestController
@CrossOrigin
public class ClientRestController {
    @Autowired
    ClientServiceImpl clientService;

    @RequestMapping(value = "/", method = RequestMethod.GET)//get List
    List<Client> getClients(){
        return clientService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)//create
    Client createClient(@RequestBody Client client){
        return clientService.create(client);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)//update
    Client updateClient(@RequestBody Client client){
        return clientService.update(client);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//get by id
    Client getClientById(@PathVariable("id")String id){
        return clientService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//delete
    Client deleteClient(@PathVariable("id") String id){
        return clientService.delete(id);
    }

}
