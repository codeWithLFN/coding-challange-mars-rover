package com.coding.challange.codingchallangemarsrover.controller;

import com.coding.challange.codingchallangemarsrover.dto.MissionRequest;
import com.coding.challange.codingchallangemarsrover.model.Plateau;
import com.coding.challange.codingchallangemarsrover.model.Rover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class MissionController {

    @PostMapping("move")
    public List<String> moveRovers(@RequestBody MissionRequest request) {
        Plateau plateau = new Plateau(request.getGridX(), request.getGridY());
        List<String> results = new ArrayList<>();

        request.getRovers().forEach(command -> {
            Rover rover = new Rover(command.getX(), command.getY(), command.getDirection(), plateau);
            rover.processCommands(command.getCommands());
            results.add(rover.getPosition());
            log.info("Rover final position: {}", rover.getPosition());
        });

        return results;
    }
}
