package cph.databases.assignment.service;

import cph.databases.assignment.entity.Handout;
import cph.databases.assignment.entity.Prescription;
import cph.databases.assignment.repository.HandoutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandoutService {
    @Autowired
    private HandoutRepo handoutRepo;

    public List<Handout> getHandoutsOfPrescription(long prescription_id){
        System.out.println("Searching for handouts");
        return handoutRepo.getOfPrescription(prescription_id);

    }

}
