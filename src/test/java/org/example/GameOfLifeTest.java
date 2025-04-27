package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private int[][]blinkerMatrix;
    private int[][]gliderMatrix;
    private int[][]blinkerMatrixOscilated;
    private Shape glider;
    private Shape blinker;
    private Shape blinkerOscilated;
    private GameOfLife gameBoard;
    private GameOfLife gameBoardExpected;
    private int[][] glider4steps;

    @BeforeEach
    public void globalVariables(){
        int[][] blinkerMatrix = {{ 1 },
                {1},
                {1}};
        int[][] gliderMatrix = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}};
        int[][] blinkerMatrixOscilated = {{0,0,0 },
                {1,1,1},
                {0,0,0}};
        int[][] glider4steps ={ {0,0,1},
                {1,0,1},
                {0,1,1}
        };
        Shape glider = new Shape(name.Glider,gliderMatrix);
        Shape blinkerOscilated = new Shape(name.Blinker,blinkerMatrixOscilated);
        GameOfLife gameBoardExpected = new GameOfLife(10,10);
        GameOfLife gameBoard = new GameOfLife(10,10);
        Shape blinker = new Shape(name.Blinker,blinkerMatrix);

    }


    @Test
    void mainTenStep(){

    }
}