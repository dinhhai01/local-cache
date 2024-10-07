package org.example.readasidecaching.controller;

import org.example.readasidecaching.model.Airport;
import org.example.readasidecaching.service.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/airport-service")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/get-all")
    public List<Airport> findAirports(){
        return airportService.findAirport();
    }
}
