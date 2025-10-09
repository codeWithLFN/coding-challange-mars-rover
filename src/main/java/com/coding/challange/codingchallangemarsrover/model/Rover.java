package com.coding.challange.codingchallangemarsrover.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rover {
    private int x;
    private int y;
    private char direction;
    private Plateau plateau;

    public void processCommands(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c){
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move();
                    break;
                default:
                    break;
            }
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction ='E';
                break;
            case 'E':
                direction = 'N';
                break;
            default:
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
            default:
                break;
        }
    }

    private void move() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'N':
                newY++;
                break;
            case 'E':
                newX++;
                break;
            case 'S':
                newY--;
                break;
            case 'W':
                newX--;
                break;
            default:
                break;
        }
        if (plateau.isInside(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + direction;
    }
}


