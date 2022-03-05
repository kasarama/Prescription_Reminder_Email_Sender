package cph.databases.assignment.rest;

import cph.databases.assignment.service.HandoutService;
import cph.databases.assignment.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/demo")
public class Resource {

    @Autowired
    ReminderService reminderService;


    @GetMapping("geturl")
    public String get() {
        return "That was a get request";
    }

    @PostMapping("posturl")
    public String post(@RequestBody String msg) {
        return "That was a post request with body: " + msg;
    }

    @GetMapping
    public String handoutsOfPrescr(@RequestParam(value = "name", required = false) String name) {
        return reminderService.hello(name);
    }


}
