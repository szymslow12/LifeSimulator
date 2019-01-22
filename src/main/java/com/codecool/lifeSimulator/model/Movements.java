package com.codecool.lifeSimulator.model;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Movements {

    private List<CommandMoves> moves = new ArrayList<>();

    public Movements() {
        createMovementList();
    }

    private void createMovementList() {
        moves.add(moveUp());
        moves.add(moveDown());
        moves.add(moveLeft());
        moves.add(moveRight());
    }

    void randomMove(Position position) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, moves.size() + 1);
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

    private void moveUpMethod(Position position) {
        int x = position.getX() - 1;
        if (x < 0) {
            x = CommandMoves.planetHight - 1;
        }
        position.setPosX(x);
    }

    private void moveDownMethod(Position position) {
        int x = position.getX() + 1;
        if (x > CommandMoves.planetHight) {
            x = 0;
        }
        position.setPosX(x);
    }

    private void moveRightMethod(Position position) {
        int y = position.getY() + 1;
        if (y > CommandMoves.planetWidth) {
            y = 0;
        }
        position.setPosY(y);
    }

    private void moveLeftMethod(Position position) {
        int y = position.getY() - 1;
        if (y < CommandMoves.planetWidth) {
            y = CommandMoves.planetWidth - 1;
        }
        position.setPosY(y);
    }

}
