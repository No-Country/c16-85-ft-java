package com.marketplace.controller;


import com.marketplace.models.entity.Location;
import com.marketplace.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @PostMapping("/create")
    public Location createLocation(@RequestBody Location newLocation) {
        return locationService.guardarlocations(newLocation);
    }


    @PutMapping("/update{id}")
    public Location updateLocation(@PathVariable Long locationId, @RequestBody Location updatedLocation) {
        return locationService.editarLocationPorID(locationId, updatedLocation);
    }


    @DeleteMapping("delete/{id}")
    public void deleteLocation(@PathVariable Long locationId) {
        locationService.locationborrar(locationId);
    }
}
