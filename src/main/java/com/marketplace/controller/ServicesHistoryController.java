package com.marketplace.controller;
import com.marketplace.DTO.servicesHistory.ServiceHistoryDTO;
import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.service.ServicesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/services-history")
public class ServicesHistoryController {

    private final ServicesHistoryService servicesHistoryService;

    @Autowired
    public ServicesHistoryController(ServicesHistoryService servicesHistoryService) {
        this.servicesHistoryService = servicesHistoryService;
    }
    @GetMapping
    public ResponseEntity<?> getAllServicesHistory() {
        List<ServiceHistoryDTO> ServiceHistoryList = servicesHistoryService.listaServicesHistory()
                .stream()
                .map(servicesHistory -> ServiceHistoryDTO.builder()
                        .serviceHistoryId(servicesHistory.getServiceHistoryId())
                        .date(servicesHistory.getDate())
                        .price(servicesHistory.getPrice())
                        .contractorProfile(servicesHistory.getContractorProfile())
                        .review(servicesHistory.getReview())
                        .professionalService(servicesHistory.getProfessionalService())
                        .build())
                .toList();
        return  ResponseEntity.ok(ServiceHistoryList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesHistory> getServicesHistoryById(@PathVariable Long id) {
        ServicesHistory servicesHistory = servicesHistoryService.buscarservHisporId(id);
        if (servicesHistory != null) {
            return new ResponseEntity<>(servicesHistory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ServicesHistory> createServicesHistory(@RequestBody ServicesHistory newServicesHistory) {
        ServicesHistory savedServicesHistory = servicesHistoryService.agregarHistory(newServicesHistory);
        return new ResponseEntity<>(savedServicesHistory, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ServicesHistory> updateServicesHistory(@PathVariable Long id,
                                                                 @RequestBody ServicesHistory updatedServicesHistory) {
        ServicesHistory editedServicesHistory = servicesHistoryService.editarHistory(id, updatedServicesHistory);
        if (editedServicesHistory != null) {
            return new ResponseEntity<>(editedServicesHistory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}