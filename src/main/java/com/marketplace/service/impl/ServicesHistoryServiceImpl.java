package com.marketplace.service.impl;

import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.repository.ServicesHistoriRepository;
import com.marketplace.service.ServicesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicesHistoryServiceImpl implements ServicesHistoryService {

    @Autowired
    ServicesHistoriRepository servicehistorirepository;


    @Override
    public ServicesHistory agregarHistory(ServicesHistory newHistory) {
        return servicehistorirepository.save(newHistory);
    }

    @Override
    public List<ServicesHistory> listaServicesHistory() {
        return servicehistorirepository.findAll();
    }

    @Override
    public ServicesHistory buscarservHisporId(UUID id) {
        Optional<ServicesHistory> optionalServicesHistory = servicehistorirepository.findById(id);
        return optionalServicesHistory.orElse(null);
    }

    @Override
    public ServicesHistory editarHistory(UUID id, ServicesHistory historiUpDate) {
        Optional<ServicesHistory> optionalServicesHistory = servicehistorirepository.findById(id);
        if (optionalServicesHistory.isPresent()) {
            ServicesHistory historyexistente = optionalServicesHistory.get();
            historyexistente.setDate(historiUpDate.getDate());
            historyexistente.setReview(historiUpDate.getReview());
            return servicehistorirepository.save(historyexistente);
        }
        return null;
    }
}
