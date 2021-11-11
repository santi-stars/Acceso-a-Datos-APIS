package com.svalero.bikesapi.controler;

import com.svalero.bikesapi.domain.Bike;
import com.svalero.bikesapi.exception.BikeNotFoundException;
import com.svalero.bikesapi.exception.ErrorResponse;
import com.svalero.bikesapi.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/bikes")   // Devuelve todas las bicis en un List  http://localhost:8081/bikes?station=12
    public List<Bike> getBikesByStationId(@RequestParam(value = "station", defaultValue = "0") int stationId) {
        List<Bike> bikes;
        // Si no le pasamos nada por parámetro stationId, por defecto es "0" y devuelve todas las bicis y si pasamos
        // un Id devuelve las bicis con ese stationId
        if (stationId == 0) {
            return bikes = bikeService.findAllBikes();
        } else {
            return bikes = bikeService.findAllBikes(stationId);
        }
    }

    @GetMapping("/bike/{id}")    // Devuelve una bici por su ID  http://localhost:8081/bike/1
    public Bike getBike(@PathVariable long id) throws BikeNotFoundException {
        Bike bike = bikeService.findBike(id);
        return bike;
    }

    @DeleteMapping("/bike/{id}")
    public Bike removeBike(@PathVariable long id) throws BikeNotFoundException {
        Bike bike = bikeService.deleteBike(id);
        return bike;
    }

    @PostMapping("/bikes")
    public Bike addBike(@RequestBody Bike bike) {   //@RequestBody recibe JSon y lo convierte a objeto JAVA
        Bike newBike = bikeService.addBike(bike);
        return newBike;
    }

    @PutMapping("/bike/{id}")
    public Bike modifyBike(@RequestBody Bike bike, @PathVariable long id) throws BikeNotFoundException {
        Bike newBike = bikeService.modifyBike(id, bike);
        return newBike;
    }

    @ExceptionHandler(BikeNotFoundException.class)
    // Método que inventa una respuesta de error con la clase ErrorResponse
    public ResponseEntity<ErrorResponse> handleBikeNotFoundException(BikeNotFoundException bnfe) {
        ErrorResponse errorResponse = new ErrorResponse("1", bnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Todo más tipos de excepciones que puedan generar errores

    @ExceptionHandler(BikeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);   // Aqui elijo el tipo de error HTTP
    }
}
