package com.emse.spring.faircorp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;



@Entity
@Table(name = "RWINDOW")
public class Window {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, length=255)
    private String name;

    @Column(nullable=false, length=255)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    @ManyToOne
    @NotNull
    private Room room;

    public Window() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Window(String name, WindowStatus status, Room room) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }
}