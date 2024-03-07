package com.marketplace.controller;

import com.marketplace.service.impl.LocationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationServiceImpl locationService;


}
