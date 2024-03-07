package com.example.API_Musica.Domain.Band;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
@Tag(name = "My_Streaming - BandController")
public class BandController {
    @Autowired
    private BandService service;

    @GetMapping(value = "/bands")
    public ResponseEntity<List<Band>> getAll() {
        List<Band> band = this.service.getAll();
        return new ResponseEntity<>(band, HttpStatus.OK);
    }

    @GetMapping(value = "/bands/{id}")
    public ResponseEntity<Band> get(@PathVariable("id") Long id) {

        return this.service.getBand(id).map(x -> new ResponseEntity<Band>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(value = "/bands")
    public ResponseEntity<Band> create(@RequestBody Band band) {
        this.service.create(band);
        return new ResponseEntity<>(band, HttpStatus.CREATED);
    }


}
