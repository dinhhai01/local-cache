package org.example.readasidecaching.service;

import org.example.readasidecaching.cache.CacheStore;
import org.example.readasidecaching.model.Airport;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AirportService {

    private final CacheStore cacheStore;

    public AirportService(CacheStore cacheStore) {
        this.cacheStore = cacheStore;
    }

    public List<Airport> findAirport(){
        return cacheStore.get("airport");
    }
}
