package com.codecool.lifeSimulator.model;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Movements {
    private int planetHight = 51;
    private int planetWidth = 92;

    private List<CommandMoves> moves = new ArrayList<>();

    Movements() {
        createMovementList();
    }

    private void createMovementList() {
        moves.add(moveUp());
        moves.add(moveDown());
        moves.add(moveLeft());
        moves.add(moveRight());
        moves.add(moveUpRight());
        moves.add(moveUpLeft());
        moves.add(moveDownRight());
        moves.add(moveDownLeft());
    }

    void randomMove(Position position) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, moves.size() );
        moves.get(randomNum).move(position);
    }

    private CommandMoves moveUp() {
        return this::moveUpMethod;
    }

    private CommandMoves moveDown() {
        return this::moveDownMethod;
    }

    private CommandMoves moveRight() {
        return this::moveRightMethod;
    }

    private CommandMoves moveLeft() {
        return this::moveLeftMethod;
    }

    private CommandMoves moveUpRight() {
        return position -> {
            moveUpMethod(position);
            moveRightMethod(position);
        };
    }

    private CommandMoves moveUpLeft() {
        return position -> {
            moveUpMethod(position);
            moveLeftMethod(position);
        };
    }

    private CommandMoves moveDownRight() {
        return position -> {
            moveDownMethod(position);
            moveRightMethod(position);
        };
    }

    private CommandMoves moveDownLeft() {
        return position -> {
            moveDownMethod(position);
            moveLeftMethod(position);
        };
    }

    private void moveUpMethod(Position position) {
        int y = position.getY() - 1;
        if (y < 0) {
            y = planetHight - 1;
        }
        position.setPosY(y);
    }

    private void moveDownMethod(Position position) {
        int y = position.getY() + 1;
        if (y > planetHight) {
            y = 0;
        }
        position.setPosY(y);
    }

    private void moveRightMethod(Position position) {
        int x = position.getX() + 1;
        if (x > planetWidth) {
            x = 0;
        }
        position.setPosX(x);
    }

    private void moveLeftMethod(Position position) {
        int x = position.getX() - 1;
        if (x < planetWidth) {
            x = planetWidth - 1;
        }
        position.setPosX(x);
    }

}
