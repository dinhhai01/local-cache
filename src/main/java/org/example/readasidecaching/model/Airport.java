package org.example.readasidecaching.model;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Airport {

    private String code;
    private String name;
}
