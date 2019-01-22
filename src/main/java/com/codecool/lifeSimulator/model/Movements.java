package com.codecool.lifeSimulator.model;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Movements {

    private List<CommandMoves> moves = new ArrayList<>();

    public Movements() {
        createMovementList();
    }

    void randomMove(Position position) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, moves.size() + 1);
        moves.get(randomNum).move(position);
    }

    private void createMovementList() {
        moves.add(moveUp());
        moves.add(moveDown());
    }

    private CommandMoves moveUp() {
        return position -> {
            int x = position.getX() - 1;
            if (x < 0) {
                x = CommandMoves.planetHight - 1;
            }
            position.setPosX(x);
        };
    }

    private CommandMoves moveDown() {
        return position -> {
            int x = position.getX() + 1;
            if (x > CommandMoves.planetHight) {
                x = 0;
            }
            position.setPosX(x);
        };
    }
}
