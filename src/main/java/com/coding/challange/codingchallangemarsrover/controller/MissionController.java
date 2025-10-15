package com.coding.challange.codingchallangemarsrover.controller;

import com.coding.challange.codingchallangemarsrover.dto.MissionRequest;
import com.coding.challange.codingchallangemarsrover.model.Plateau;
import com.coding.challange.codingchallangemarsrover.model.Rover;
import lombok.Builder;
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

        if (request.getGridX() < 0 || request.getGridY() < 0) {
            throw new IllegalArgumentException("Grid dimensions must be positive values.");
        }

        var plateau = Plateau.builder()
                .maxX(request.getGridX())
                .maxY(request.getGridY())
                .build();

        List<String> results = new ArrayList<>();

        request.getRovers().forEach(command -> {

            if (!plateau.isInside(command.getX(), command.getY())) {
                throw new IllegalArgumentException(
                        String.format("Rover starting position (%d,%d) is outside plateau (%d,%d).",
                                command.getX(), command.getY(), plateau.getMaxX(), plateau.getMaxY())
                );
            }

            var rover = Rover.builder()
                    .x(command.getX())
                    .y(command.getY())
                    .direction(command.getDirection())
                    .plateau(plateau)
                    .build();
            rover.processCommands(command.getCommands());
            results.add(rover.getPosition());
            log.info("Rover final position: {}", rover.getPosition());
        });

        return results;
    }
}

