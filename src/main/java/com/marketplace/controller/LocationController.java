package com.marketplace.controller;


import com.marketplace.models.entity.Location;
import com.marketplace.DTO.location.LocationDTO;
import com.marketplace.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("find/all")
    public ResponseEntity<?> getAllLocations() {
        List<LocationDTO> locationsList = locationService.listLocations()
                .stream()
                .map(location -> LocationDTO.builder()
                        .locationId(location.getLocationId())
                        .city(location.getCity())
                        .country(location.getCity())
                        .build())
                .toList();
        return  ResponseEntity.ok(locationsList);


    }


    @GetMapping("find/{id}")
    public ResponseEntity<?>getLocationById(@PathVariable Long locationId) {
        Optional<Location> locationOptional = Optional.ofNullable(locationService.buscarPorId(locationId));

        if(locationOptional.isPresent()){
            Location location = locationOptional.get();
            LocationDTO locatationDTO = LocationDTO.builder()
                    .locationId(location.getLocationId())
                    .city(location.getCity())
                    .country(location.getCity())
                    .build();

            return ResponseEntity.ok(locatationDTO);

        }
        return ResponseEntity.notFound().build();
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
