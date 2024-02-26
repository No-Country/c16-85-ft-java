

package com.marketplace.service.impl;

import com.marketplace.models.entity.Location;
import com.marketplace.models.valueobjets.address.Address;
import com.marketplace.repository.LocationRepository;
import com.marketplace.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationrepository;
    @Override
    public List<Location> listLocations() {
        return locationrepository.findAll();
    }

    @Override
    public Location buscarPorId(Long id) {
        Optional<Location> optionalLocation = locationrepository.findById(id);
        return optionalLocation.orElse(null);
    }

    public void createLocation(Address address, String city,
                               String province, String country,
                               String coordinates){

        var location = Location.builder()
                .address(address)
                .city(city)
                .province(province)
                .country(country)
                .coordinates(coordinates)
                .build();

        locationrepository.save(location);

    }

    public Location createMarDelPlataLocation(Address address){

        return Location.builder()
                .address(address)
                .city("Mar del Plata")
                .province("Buenos Aires")
                .country("Argentina")
                .coordinates("")
                .build();

    }


    @Override
    public Location guardarlocations(Location newlocation) {
        return locationrepository.save(newlocation);
    }
    @Override
    public Location editarLocationPorID(Long id, Location locationActualizada) {
        Optional<Location> optionalLocation = locationrepository.findById(id);
        if (optionalLocation.isPresent()) {
            Location locationExistente = optionalLocation.get();
            locationExistente.setCity(locationActualizada.getCity());
            locationExistente.setCountry(locationActualizada.getCountry());
            locationExistente.setAddress(locationActualizada.getAddress());
            return locationrepository.save(locationExistente);
        }
        return null;
    }

    @Override
    public void locationborrar(Long id) {
        locationrepository.deleteById(id);

    }

}