package cph.databases.assignment;

import cph.databases.assignment.service.HandoutService;
import cph.databases.assignment.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import java.util.Date;

@SpringBootApplication
@EnableScheduling

public class PrescriptionReminderApplication {

    /**
     * todo implement Scheduling
     * https://bykowski.pl/spring-boot-21-zadania-cykliczne-i-harmonogramy/
     */

    @Autowired
    static ReminderService reminder;

    public static void main(String[] args) {
        SpringApplication.run(PrescriptionReminderApplication.class, args);

    }

    //executes every day at 5 am
    @Schedules({@Scheduled(cron = "0 7 19 * * *")})
    public void remind() {
        reminder.sendReminders();
    }

    // executes every 60 seconds
    @Schedules({
            @Scheduled(fixedDelay = 60000)
    })
    public void demo() {
        System.out.println(new Date().toString());
    }


}
