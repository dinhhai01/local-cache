package org.example.readasidecaching.cache;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.SneakyThrows;
import org.example.readasidecaching.model.Airport;
import org.example.readasidecaching.repository.AirportRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
public class CacheStore {

    private Cache<String, String> cache;
    private final AirportRepository airportRepository;

    public CacheStore(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
    }


    @SneakyThrows
    public List<Airport> get(String key){
        String data = cache.getIfPresent(key);
        if(data==null){
            List<Airport> airportList = airportRepository.getByKey(key);
            add(key, airportList);
            return airportList;
        }
        List<Airport> airports = new ObjectMapper().readValue(data, new TypeReference<List<Airport>>() {
        });
        return airports;
    }

    @SneakyThrows
    public void add(String key, List<Airport> value){
        if(key!=null && value!=null){
            String dataJson = new ObjectMapper().writeValueAsString(value);
            cache.put(key, dataJson);
        }
    }


}
