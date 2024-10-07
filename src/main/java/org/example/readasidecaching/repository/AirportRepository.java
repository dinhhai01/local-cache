package org.example.readasidecaching.repository;


import org.example.readasidecaching.model.Airport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportRepository {

    public List<Airport> getByKey(String key){
        return List.of(new Airport().setCode("1234").setName("airport"));
    }
}
