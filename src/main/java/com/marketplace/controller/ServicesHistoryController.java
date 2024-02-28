package com.marketplace.controller;
import com.marketplace.DTO.servicesHistory.ServicesHistorySimple;
import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.service.ServicesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/history")
public class ServicesHistoryController {

    private final ServicesHistoryService servicesHistoryService;

    @Autowired
    public ServicesHistoryController(ServicesHistoryService servicesHistoryService) {
        this.servicesHistoryService = servicesHistoryService;
    }
    /**
     * Metodo que trae una lista de la Entidad Serviceshistory */
    @GetMapping("/")
    public ResponseEntity<?> getAllServicesHistory() {
        List<ServicesHistorySimple> ServiceHistoryList = servicesHistoryService.listServicesHistory()
                .stream()
                .map(servicesHistory -> ServicesHistorySimple.builder()
                        .serviceHistoryId(servicesHistory.getId())
                        .date(servicesHistory.getDate())
                        .price(servicesHistory.getPrice())
                        .review(servicesHistory.getReview())
                        .build())
                .toList();
        return  ResponseEntity.ok(ServiceHistoryList);

    }
    /**
     * Metodo que trae un dato por ID de la Entidad Serviceshistory*/
    @GetMapping("find/{id}")
    public ResponseEntity<ServicesHistory> getServicesHistoryById(@PathVariable Long id) {
        ServicesHistory servicesHistory = servicesHistoryService.searchHistorybyId(id);

        if (servicesHistory != null) {
            return new ResponseEntity<>(servicesHistory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Metodo que agrega datos en la Entidad Serviceshistory*/
    @PostMapping("/create")
    public ResponseEntity<ServicesHistory> createServicesHistory(@RequestBody ServicesHistory newServicesHistory) {
        ServicesHistory savedServicesHistory = servicesHistoryService.addHistory(newServicesHistory);
        return new ResponseEntity<>(savedServicesHistory, HttpStatus.CREATED);
    }
    /**
     * Metodo que edita datos por ID de la Entidad Serviceshistory*/
    @PutMapping("/edit/{id}")
    public ServicesHistory editarLocationPorID(@PathVariable Long id, @RequestBody ServicesHistory historyUpDate) {

        Optional<ServicesHistory> optionalServicesHistory = Optional.ofNullable(servicesHistoryService.editHistory(id, historyUpDate));
        if (optionalServicesHistory.isPresent()) {
            ServicesHistory servicesHistoryExistente = optionalServicesHistory.get();
            servicesHistoryExistente.setPrice(historyUpDate.getPrice());
            servicesHistoryExistente.setDate(historyUpDate.getDate());
            return servicesHistoryService.addHistory(servicesHistoryExistente);
        }



        return null;
    }
    /**
     * Metodo que elimina datos por ID de la Entidad Serviceshistory*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long id){
        servicesHistoryService.deleteHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
