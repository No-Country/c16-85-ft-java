package com.marketplace.service;

import com.marketplace.models.entity.ServicesHistory;

import java.util.List;
import java.util.UUID;

public interface ServicesHistoryService {

    ServicesHistory addHistory(ServicesHistory newHistory);

    List<ServicesHistory> listServicesHistory();

    ServicesHistory searchHistorybyId(Long id);

    ServicesHistory editHistory(Long id, ServicesHistory historyUpDate);

    void deleteHistory (Long id);

}

