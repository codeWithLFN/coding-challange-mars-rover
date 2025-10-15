package com.coding.challange.codingchallangemarsrover.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Plateau {
    private int maxX;
    private int maxY;

    public boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x <= maxX && y <= maxY;
    }
}

