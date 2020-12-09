package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;


/*
-each room has zero or more heaters,
 has zero or more windows,
 a name, OK
  a floor, OK
   a current temperature, OK
    a target temperature. OK
 */

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, length=255)
    private String name;

    private Double currentTemperature;

    private Double targetTemperature;

    @Column(nullable=false, length=255)
    private Integer floor;

    @OneToMany(targetEntity=Window.class, mappedBy="room")
    private Set<Window> windows;

    @OneToMany(targetEntity=Heater.class, mappedBy="room")
    private Set<Heater> heaters;



    public Room() {
    }

    public Room(String name, Double currentTemperature, Double targetTemperature, Integer floor) {
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.floor=floor;
    }


    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Long getId() {
        return this.id;
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

    public Set<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }



    public Set<Window> getWindows() {
        return windows;
    }

    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }
}