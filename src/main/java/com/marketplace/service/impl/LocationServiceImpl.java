package com.marketplace.service.impl;

import com.marketplace.models.entity.Location;
import com.marketplace.repository.LocationRepository;
import com.marketplace.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {


    @Autowired
    LocationRepository locationrepository;
    @Override
    public List<Location> listLocations() {
        return locationrepository.findAll();
    }

    @Override
    public Location buscarPorId(UUID id) {
        Optional<Location> optionalLocation = locationrepository.findById(id);
        return optionalLocation.orElse(null);
    }

    @Override
    public Location guardarlocations(Location newlocation) {
        return locationrepository.save(newlocation);
    }
    @Override
    public Location editarLocationPorID(UUID id, Location locationActualizada) {
        Optional<Location> optionalLocation = locationrepository.findById(id);
        if (optionalLocation.isPresent()) {
            Location locationExistente = optionalLocation.get();
            locationExistente.setCity(locationActualizada.getCity());
            locationExistente.setCountry(locationActualizada.getCountry());
            locationExistente.setAddres(locationActualizada.getAddres());
            return locationrepository.save(locationExistente);
        }
        return null;
    }

    @Override
    public void locationborrar(UUID id) {
    locationrepository.deleteById(id);
    }


}
