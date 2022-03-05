package cph.databases.assignment.repository;

import cph.databases.assignment.entity.EmailLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailLogRepo extends CrudRepository<EmailLog, Long> {

}
