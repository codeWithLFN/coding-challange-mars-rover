package com.coding.challange.codingchallangemarsrover.dto;

import lombok.Data;
import java.util.List;

@Data
public class MissionRequest {
    private int gridX;
    private int gridY;
    private List<RoverCommand> rovers;

    @Data
    public static class RoverCommand {
        private int x;
        private int y;
        private char direction;
        private String commands;

    }
}

