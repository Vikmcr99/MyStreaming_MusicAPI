package com.example.API_Musica.Domain.Music;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
@Tag(name = "My_Streaming - MusicController")
public class MusicController {

    @Autowired
    private MusicService service;

    @GetMapping(value = "/musics/{id}")
    public ResponseEntity<Music> getMusic(@PathVariable("id")Long id) {
        Random rand = new Random();
        int n = rand.nextInt(100);
        if (n % 2 == 0) {
            return this.service.getMusic(id).map(x -> new ResponseEntity<Music>(x, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
