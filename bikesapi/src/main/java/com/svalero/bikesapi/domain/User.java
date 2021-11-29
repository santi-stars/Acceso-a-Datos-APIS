package com.svalero.bikesapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String dni;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy ="user")    // Indica que he mapeado en el campo user en la clase Route que ponemos en el List
    private List<Route> routes;
}
