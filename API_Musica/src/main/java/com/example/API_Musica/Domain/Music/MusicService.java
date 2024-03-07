package com.example.API_Musica.Domain.Music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private  MusicRepository repository;

    public Optional<Music> getMusic(Long id) {
        return this.repository.findById(id);
    }
}

