package com.marketplace.service;

import com.marketplace.models.entity.ServicesHistory;

import java.util.List;
import java.util.UUID;

public interface ServicesHistoryService {

    ServicesHistory agregarHistory(ServicesHistory newHistory);

    List<ServicesHistory> listaServicesHistory();

    ServicesHistory buscarservHisporId(Long id);

    ServicesHistory editarHistory(Long id, ServicesHistory historyUpDate);

}

