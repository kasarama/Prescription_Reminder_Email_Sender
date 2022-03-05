package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Prescription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrescriptionRepo extends CrudRepository<Prescription, Long> {

    @Query("select p from Prescription p where p.validUntil = ?1")
    List<Prescription> findPrescriptionThatExpireBy(Date date);


    @Query("select p from Prescription p where p.remainingHandouts = ?1")
    List<Prescription> findPrescriptionWIthHandoutsLessThan(int handouts);


}
