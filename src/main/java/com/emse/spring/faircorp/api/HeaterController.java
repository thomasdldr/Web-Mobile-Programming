package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/heaters") // (2)
@Transactional // (3)
public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) { // (4)
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping // (5)
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }

    @PostMapping // (8)
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // HeaterDto must always contain the heater room
        Room room = roomDao.getOne(dto.getRoomId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater( dto.getName(), dto.getHeaterStatus(), dto.getPower(), room ) );
        }
        else {
            heater = heaterDao.getOne(dto.getId());  // (9)
            heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}