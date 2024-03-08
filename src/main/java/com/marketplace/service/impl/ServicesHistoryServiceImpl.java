package com.marketplace.service.impl;

import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.repository.ServicesHistoryRepository;
import com.marketplace.service.ServicesHistoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesHistoryServiceImpl implements ServicesHistoryService {

    @Autowired
    ServicesHistoryRepository servicesHistoryRepository;


    @Override
    public ServicesHistory addHistory(ServicesHistory newHistory) {
        return servicesHistoryRepository.save(newHistory);
    }

    @Override
    public List<ServicesHistory> listServicesHistory() {
        return servicesHistoryRepository.findAll();
    }

    @Override
    public ServicesHistory searchHistorybyId(Long id) {
        Optional<ServicesHistory> optionalServicesHistory = servicesHistoryRepository.findById(id);
        return optionalServicesHistory.orElse(null);
    }

    @Override
    public ServicesHistory editHistory(Long id, ServicesHistory historyUpDate) {
        Optional<ServicesHistory> optionalServicesHistory = servicesHistoryRepository.findById(id);
        if (optionalServicesHistory.isPresent()) {
            ServicesHistory historyexistente = optionalServicesHistory.get();
            historyexistente.setDate( historyUpDate.getDate());
            historyexistente.setReview( historyUpDate.getReview());
            return servicesHistoryRepository.save(historyexistente);
        }
        return null;


    }

    @Override
    public void deleteHistory(Long id) {
        servicesHistoryRepository.deleteById(id);
    }

}


