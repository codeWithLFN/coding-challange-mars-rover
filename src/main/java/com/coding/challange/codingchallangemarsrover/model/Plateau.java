package com.coding.challange.codingchallangemarsrover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Plateau {
    private int maxX;
    private int maxY;

    public boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x <= maxX && y <= maxY;
    }
}

