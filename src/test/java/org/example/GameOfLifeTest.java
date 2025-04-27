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
    private Shape gliderAtTwoSteps;
    private int[][] gliderTwoSteps;
    private GameOfLife gameBoard;
    private GameOfLife gameBoardExpected;
    private int[][] glider2steps;

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
        int[][] gliderTwoSteps ={ {0,0,1},
                {1,0,1},
                {0,1,1}
        };
         glider = new Shape(name.Glider,gliderMatrix);
         blinkerOscilated = new Shape(name.Blinker,blinkerMatrixOscilated);
         blinker = new Shape(name.Blinker,blinkerMatrix);
         gliderAtTwoSteps = new Shape(name.Glider,gliderTwoSteps);

    }
    @Test
    void mainFourSteps() {
        int i=0;
        GameOfLife gameBoardExpected = new GameOfLife(10,10);
        GameOfLife gameBoard = new GameOfLife(10,10);
        gameBoard.addShape(blinker,5,5);
        gameBoard.addShape(glider,0,0);
        gameBoardExpected.addShape(glider,1,1);
        gameBoardExpected.addShape(blinker,5,5);
        BoolMatrixPrinter printedGameBoard = new BoolMatrixPrinter();
        String boardVisualizer=printedGameBoard.printMatrix(gameBoard);
        String boardExpected=printedGameBoard.printMatrix(gameBoardExpected);
        while (i<4){
            gameBoard.step();
            boardVisualizer=printedGameBoard.printMatrix(gameBoard);
            //System.out.println(boardVisualizer);
            i++;
        }
        //System.out.println(boardExpected);
        //System.out.println(boardVisualizer);
        assertArrayEquals(gameBoard.getData(), gameBoardExpected.getData());

    }


    @Test
    void mainTenStep(){
        int i=0;
        GameOfLife gameBoardExpected = new GameOfLife(10,10);
        GameOfLife gameBoard = new GameOfLife(10,10);
        gameBoard.addShape(blinker,7,5);
        gameBoard.addShape(glider,0,0);
        gameBoardExpected.addShape(gliderAtTwoSteps,3,2);
        gameBoardExpected.addShape(blinker,7,5);
        BoolMatrixPrinter printedGameBoard = new BoolMatrixPrinter();
        String boardVisualizer=printedGameBoard.printMatrix(gameBoard);
        String boardExpected=printedGameBoard.printMatrix(gameBoardExpected);
        System.out.println(boardVisualizer);

        while (i<10){
            gameBoard.step();
            boardVisualizer=printedGameBoard.printMatrix(gameBoard);
            //System.out.println(boardVisualizer);
            i++;
        }
        System.out.println(boardExpected);
        System.out.println(boardVisualizer);
        assertArrayEquals(gameBoard.getData(), gameBoardExpected.getData());

    }
}