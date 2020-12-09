package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    //fonction deleteWindows à implémenter

    /*
    @Override
    public void
    @Override
    public void deleteWindows(String Name) {
        RoomDaoCustomImpl roomDao = new RoomDaoCustomImpl() ;
        List<Room> rooms = roomDao.findRoomByName("Room1");
        Room room = rooms.get(0);
        List<Window> windows = (List<Window>) room.getWindows();
        for(Window window : windows){
            window = null ;
        }

    }

      deleteWindows(String Name) {
        RoomDaoCustomImpl roomDao = new RoomDaoCustomImpl() ;
        List<Room> rooms = roomDao.findRoomByName("Room1");
        Room room = rooms.get(0);
        List<Window> windows = (List<Window>) room.getWindows();
        for(Window window : windows){
            window = null ;
        }

    }

     */



}