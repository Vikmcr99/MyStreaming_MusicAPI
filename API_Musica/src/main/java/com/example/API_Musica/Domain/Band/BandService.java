package com.example.API_Musica.Domain.Band;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    @Autowired
    private BandRepository repository;

    public void create(Band band) {
        this.repository.save(band);
    }

    public Optional<Band> getBand(Long id) {
        return this.repository.findById(id);
    }

    public List<Band> getAll() {
        return this.repository.findAll();
    }

}
