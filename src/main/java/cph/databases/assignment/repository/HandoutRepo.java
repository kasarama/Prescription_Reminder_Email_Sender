package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Handout;
import cph.databases.assignment.entity.Prescription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HandoutRepo extends CrudRepository<Handout, Long> {

    @Query("select h from Handout h where h.prescription.id = ?1")
    List<Handout> getOfPrescription(long id);


}
