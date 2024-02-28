package com.marketplace.controller;

import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.service.ServicesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/history")
public class ServicesHistoryController {

    private final ServicesHistoryService servicesHistoryService;

    @Autowired
    public ServicesHistoryController(ServicesHistoryService servicesHistoryService) {
        this.servicesHistoryService = servicesHistoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ServicesHistory>> getAllServicesHistory() {
        List<ServicesHistory> servicesHistoryList = servicesHistoryService.listServicesHistory();
        return new ResponseEntity<>(servicesHistoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesHistory> getServicesHistoryById(@PathVariable Long id) {
        ServicesHistory servicesHistory = servicesHistoryService.searchHistorybyId(id);
        if (servicesHistory != null) {
            return new ResponseEntity<>(servicesHistory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<ServicesHistory> createServicesHistory(@RequestBody ServicesHistory newServicesHistory) {
        ServicesHistory savedServicesHistory = servicesHistoryService.addHistory(newServicesHistory);
        return new ResponseEntity<>(savedServicesHistory, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ServicesHistory> updateServicesHistory(@PathVariable Long id,
                                                                 @RequestBody ServicesHistory updatedServicesHistory) {
        ServicesHistory editedServicesHistory = servicesHistoryService.editHistory(id, updatedServicesHistory);
        if (editedServicesHistory != null) {
            return new ResponseEntity<>(editedServicesHistory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteHistory(@PathVariable Long id){
            servicesHistoryService.deleteHistory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }