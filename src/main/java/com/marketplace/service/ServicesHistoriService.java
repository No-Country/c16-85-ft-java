package com.marketplace.service;

import com.marketplace.models.entity.ServicesHistory;

import java.util.List;
import java.util.UUID;

public interface ServicesHistoriService {

    ServicesHistory agregarHistory(ServicesHistory newHistory);

    List<ServicesHistory> listaServicesHistory();

    ServicesHistory buscarservicesHistory(UUID id);

    ServicesHistory editarHistory(UUID id, ServicesHistory historiUpDate);

}

