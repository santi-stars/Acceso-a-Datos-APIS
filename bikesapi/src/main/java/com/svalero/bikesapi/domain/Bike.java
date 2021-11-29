package com.svalero.bikesapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bikes")   // Crea la tabla bikes
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera clave autoincremental
    private long id;
    @Column
    private boolean available;
    @Column
    private int kilometers;
    @Column
    private int battery;
    @Column(name = "baby_chair")
    private boolean babyChair;
    @Column(name = "station_id")
    private int stationId;

    @OneToMany(mappedBy ="bike")    // Indica que he mapeado en el campo user en la clase Route que ponemos en el List
    private List<Route> routes;
}
