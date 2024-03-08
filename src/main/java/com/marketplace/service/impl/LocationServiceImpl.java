

package com.marketplace.service.impl;

import com.marketplace.models.entity.Location;
import com.marketplace.models.valueobjets.address.Address;
import com.marketplace.repository.LocationRepository;
import com.marketplace.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired
    LocationRepository locationrepository;

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

        Location location = Location.builder()
                .address(address)
                .city("Mar del Plata")
                .province("Buenos Aires")
                .country("Argentina")
                .coordinates("")
                .build();

        locationrepository.save(location);

        return location;

    }


}