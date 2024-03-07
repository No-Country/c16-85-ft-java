package com.marketplace.service.impl;

import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.repository.ServiceHistoryRepository;
import com.marketplace.service.ServicesHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicesHistoryServiceImpl implements ServicesHistoryService {

    private final ServiceHistoryRepository serviceHistoryRepository;


    @Override
    public ServicesHistory addHistory(ServicesHistory newHistory) {
        return serviceHistoryRepository.save(newHistory);
    }

    @Override
    public List<ServicesHistory> listServicesHistory() {
        return serviceHistoryRepository.findAll();
    }

    @Override
    public ServicesHistory searchHistorybyId(Long id) {
        Optional<ServicesHistory> optionalServicesHistory = serviceHistoryRepository.findById(id);
        return optionalServicesHistory.orElse(null);
    }

    @Override
    public ServicesHistory editHistory(Long id, ServicesHistory historyUpDate) {
        Optional<ServicesHistory> optionalServicesHistory = serviceHistoryRepository.findById(id);
        if (optionalServicesHistory.isPresent()) {
            ServicesHistory historyexistente = optionalServicesHistory.get();
            historyexistente.setDate( historyUpDate.getDate());
            historyexistente.setReview( historyUpDate.getReview());
            return serviceHistoryRepository.save(historyexistente);
        }
        return null;


    }

    @Override
    public void deleteHistory(Long id) {

        serviceHistoryRepository.deleteById(id);
    }

}


