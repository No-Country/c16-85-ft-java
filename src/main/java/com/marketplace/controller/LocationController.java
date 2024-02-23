package com.marketplace.controller;


import com.marketplace.models.entity.Location;
import com.marketplace.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.listLocations();
    }


    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable long locationId) {
        return locationService.buscarPorId(locationId);
    }


    @PostMapping
    public Location createLocation(@RequestBody Location newLocation) {
        return locationService.guardarlocations(newLocation);
    }


    @PutMapping("/{id}")
    public Location updateLocation(@PathVariable long locationId, @RequestBody Location updatedLocation) {
        return locationService.editarLocationPorID(locationId, updatedLocation);
    }


    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable long locationId) {
        locationService.locationborrar(locationId);;
    }
}
