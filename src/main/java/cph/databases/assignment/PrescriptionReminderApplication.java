package cph.databases.assignment;

import cph.databases.assignment.service.HandoutService;
import cph.databases.assignment.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import java.util.Date;

@SpringBootApplication
@EnableScheduling

public class PrescriptionReminderApplication {


    @Autowired
    private ReminderService reminder;

    public static void main(String[] args) {
        SpringApplication.run(PrescriptionReminderApplication.class, args);

    }

    //executes every day at 07:20 PM
    @Schedules({@Scheduled(cron = "0 20 19 * * *")})
    public void remind() {
        System.out.println("SCHEDULED ");
        int q = reminder.sendReminders();
        System.out.println(q + " emails are sent.");

    }

    // executes every 20 seconds
    @Schedules({
            @Scheduled(fixedDelay = 20000)
    })
    public void demo() {
        System.out.print("DEMO: \t");
        System.out.println(new Date().toString());
        System.out.println(reminder.hello("Main Class"));
    }


}
