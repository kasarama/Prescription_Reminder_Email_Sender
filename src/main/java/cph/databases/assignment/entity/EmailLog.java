package cph.databases.assignment.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "email_logs")
public class EmailLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private final Date date = new Date();
    private long prescription_id;

    public EmailLog() {
    }

    public EmailLog(long prescription_id) {
        this.prescription_id = prescription_id;
    }
}

