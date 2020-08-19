package pan.edu.hotel.controller.web;    /*
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
import pan.edu.hotel.model.Client;
import pan.edu.hotel.service.client.impls.ClientServiceImpl;

@RequestMapping("/web/client")
@Controller
public class ClientWebController {

    @Autowired
    ClientServiceImpl clientService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String showAll(Model model){
        model.addAttribute("list",clientService.getAll());
        return "clientList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createClient(Model model){
        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);
        return "addClient";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCafedra(Model model, @ModelAttribute("clientForm") ClientForm clientForm){
        Client client = new Client();
        client.setSurname(clientForm.getSurname());
        client.setName(clientForm.getName());
        client.setPatronymic(clientForm.getPatronymic());
        client.setPassport(clientForm.getPassport());
        client.setComment(clientForm.getComment());
        clientService.create(client);

        model.addAttribute("clients", clientService.getAll());
        return "redirect:/web/client/get/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateClient(@PathVariable("id") String id,Model model) {
        Client client = clientService.get(id);
        ClientForm clientForm = new ClientForm(
                client.getId(),
                client.getDescription(),
                client.getSurname(),
                client.getName(),
                client.getPatronymic(),
                client.getPassport(),
                client.getComment()
        );
        model.addAttribute("clientForm", clientForm);
        return "addClient";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateCafedra(Model model,@PathVariable("id") String id, @ModelAttribute("clientForm") ClientForm clientForm){
        Client client = new Client();
        client.setId(id);
        client.setSurname(clientForm.getSurname());
        client.setName(clientForm.getName());
        client.setPatronymic(clientForm.getPatronymic());
        client.setPassport(clientForm.getPassport());
        client.setComment(clientForm.getComment());
        clientService.update(client);

        model.addAttribute("clients", clientService.getAll());
        return "redirect:/web/client/get/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteClientById(@PathVariable("id") String id, Model model){
        clientService.delete(id);
        model.addAttribute("list",clientService.getAll());
        return "redirect:/web/client/get/list";
    }


}
