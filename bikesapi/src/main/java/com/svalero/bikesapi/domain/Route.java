package com.svalero.bikesapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate startDate;
    @Column
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate endDate;
    @Column
    private int kilometers;

    @ManyToOne      // Tipo de relacion
    @JoinColumn(name = "bike_id")   // Tabla con la que relaciona
    @JsonBackReference  // Para que no haga un bucle con los objetos bike y user que contienen route y a su vez
    // bike y user y haría un bucle de datos al devolvernos el Json
    private Bike bike;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
