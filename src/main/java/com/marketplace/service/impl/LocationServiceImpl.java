

package com.marketplace.service.impl;

import com.marketplace.models.entity.Location;
import com.marketplace.repository.LocationRepository;
import com.marketplace.service.LocationService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {}

  /*  @Autowired
    LocationRepository locationrepository;

    public Location editarLocationPorID(Long id, Location locationActualizada) {
        Optional<Location> optionalLocation = locationrepository.findById(id);
        if (optionalLocation.isPresent()) {
            Location locationExistente = optionalLocation.get();
            locationExistente.setAddress(locationActualizada.getAddress());
            return locationrepository.save(locationExistente);
        }
        return null;
    } */



