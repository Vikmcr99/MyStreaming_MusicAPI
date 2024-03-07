package com.example.API_Musica.Domain.Music;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "tb_music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column
    private String name;
    @Column
    private double duration;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
