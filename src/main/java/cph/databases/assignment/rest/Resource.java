package cph.databases.assignment.rest;

import cph.databases.assignment.entity.Handout;
import cph.databases.assignment.service.HandoutService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/demo")
public class Resource {

    final
    HandoutService handoutService;

    public Resource(HandoutService handoutService) {
        this.handoutService = handoutService;
    }

    @GetMapping("geturl")
    public String get() {
        return "That was a get request";
    }

    @PostMapping("posturl")
    public String post(@RequestBody String msg) {
        return "That was a post request with body: " + msg;
    }

    @GetMapping
    public List<Handout> handoutsOfPrescr(@PathParam("presc_id") Long id){
        System.out.println("ID IS: "+id);
        return handoutService.getHandoutsOfPrescription(id);
    }


}
