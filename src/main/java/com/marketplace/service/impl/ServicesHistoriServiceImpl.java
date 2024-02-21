package com.marketplace.service.impl;

import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.repository.ServicesHistoriRepository;
import com.marketplace.service.ServicesHistoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicesHistoriServiceImpl implements ServicesHistoriService {

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
    public ServicesHistory buscarservicesHistory(UUID id) {
        Boolean existe = servicehistorirepository.existsById(id);
        if (existe){

        }
    }

    @Override
    public ServicesHistory editarHistory(UUID id, ServicesHistory historiUpDate) {
        return null;
    }
}
