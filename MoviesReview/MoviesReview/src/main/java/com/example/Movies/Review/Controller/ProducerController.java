package com.example.Movies.Review.Controller;

import com.example.Movies.Review.Dto.DTo;
import com.example.Movies.Review.Service.MovieService;
import com.example.Movies.Review.entities.Producers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProducerController {
    @Autowired
    private MovieService service;

    @PostMapping("/insert-producers-data")
    public ResponseEntity<Producers> insertProducers(@RequestBody Producers producers) {
        try {
            log.info("insertion is started"+producers.toString());
            return new ResponseEntity<>(service.insertProducers(producers), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/producers")
    public ResponseEntity<List<Producers>> getProducers() {
        try {
            log.info("getting data is started");
            return new ResponseEntity<>(service.getProducers(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error found at getting all producers list");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-Producer/{producerId}")
    public ResponseEntity<Producers> updateProducer(@PathVariable("producerId")int producerId, @RequestBody DTo dto){
        return service.updateProducer(producerId,dto);
    }
@DeleteMapping("/{producerId}")
    public void delProducer(@PathVariable("producerId") int producerId){
        service.delProducer(producerId);
    }


}
