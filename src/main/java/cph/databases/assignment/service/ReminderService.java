package cph.databases.assignment.service;

import cph.databases.assignment.entity.EmailLog;
import cph.databases.assignment.entity.Person;
import cph.databases.assignment.entity.Prescription;
import cph.databases.assignment.repository.EmailLogRepo;
import cph.databases.assignment.repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ReminderService {
    @Autowired
    private PrescriptionRepo prescriptionRepo;
    @Autowired
    private EmailLogRepo emailLogRepo;

    @Autowired
    private JavaMailSender mailSender;


    private void sendEmail(String toEmail,
                           String subject,
                           String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@selself.com");
        message.setText(body);
        message.setTo(toEmail);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("mail sent successfully");
    }

    public int sendReminders() {
        LocalDateTime in3days = LocalDateTime.now().plusDays(3);
        Date date = Date.from(in3days.atZone(ZoneId.systemDefault()).toInstant());


        List<Prescription> list = prescriptionRepo.findPrescriptionThatExpireBy(date);
        List<String> mail_list = new ArrayList<>();

        for (Prescription p : list) {
            String msg = msg(p, date);
            String email = p.getPatient().getCpr().getCi().getMail();
            sendEmail(email, "Your prescription expires in three days", msg);
            EmailLog log = new EmailLog(p.getId());
            emailLogRepo.save(log);
        }
        return list.size();
    }

    private String msg(Prescription p, Date date) {

        String msg = String.format("Dear %s %s\nYour prescription for %s is abut to expire.\nThe last day for handout of your prescription is on %s.\nKind regards\nPrescription Service\n\nP.S. Sorry fir the date format. It should be though fine for Prove of Concept",
                p.getPatient().getCpr().getFirstName(),
                p.getPatient().getCpr().getLastName(),
                p.getDose().getDrug().getName(),
                date.toString()
        );
        return msg;
    }

    public String hello(String name) {
        return "Hello, " + name + "!";
    }
}
