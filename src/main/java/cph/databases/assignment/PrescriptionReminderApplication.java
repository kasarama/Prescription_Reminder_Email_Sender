package cph.databases.assignment;

import cph.databases.assignment.service.EmailSenderService;
import cph.databases.assignment.service.HandoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrescriptionReminderApplication implements CommandLineRunner {


    /**
     * todo implement Scheduling
     * https://bykowski.pl/spring-boot-21-zadania-cykliczne-i-harmonogramy/
     */



    public static void main(String[] args) {
        SpringApplication.run(PrescriptionReminderApplication.class, args);
        System.out.println("HAHas");

    }
    @Bean
    public HandoutService handoutService() {
        return new HandoutService();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
