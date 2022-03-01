package cph.databases.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandoutService {
    final
    HandoutService handoutService;

    public HandoutService(HandoutService handoutService) {
        this.handoutService = handoutService;
    }
}
