package com.marketplace.service;



import com.marketplace.models.entity.Location;

import java.util.List;
import java.util.UUID;

public interface LocationService {

    List<Location> listLocations();

    Location buscarPorId(Long id);


    Location guardarlocations(Location newlocation);

    Location editarLocationPorID (Long id, Location locationActulizada);

    void locationborrar (Long id);
}