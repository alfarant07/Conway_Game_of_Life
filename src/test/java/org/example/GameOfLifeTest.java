package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//------------------------------------------------------
// Assignment (1)
// Written by: (Anthony Alfaro 2148110)
// For SES350 Section (602) – Spring 2025
//The following program is designed to test the GameOfLife board after given steps
//--------------------------------------------------------
class GameOfLifeTest {
    private int[][]blinkerMatrix;
    private int[][]gliderMatrix;
    private int[][]blinkerMatrixOscilated;
    private Shape glider;
    private Shape blinker;
    private Shape blinkerOscilated;
    private Shape gliderAtOneStep;

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
        int[][] gliderOneStep ={ {1,0,1},
                {0,1,1},
                {0,1,0}
        };
         glider = new Shape(name.Glider,gliderMatrix);
         blinkerOscilated = new Shape(name.Blinker,blinkerMatrixOscilated);
         blinker = new Shape(name.Blinker,blinkerMatrix);
         gliderAtTwoSteps = new Shape(name.Glider,gliderTwoSteps);
        gliderAtOneStep = new Shape(name.Glider,gliderOneStep);


    }
    @Test
    void mainStep(){
        int i=0;
        GameOfLife gameBoardExpected = new GameOfLife(10,10);
        GameOfLife gameBoard = new GameOfLife(10,10);
        gameBoard.addShape(blinker,7,5);
        gameBoard.addShape(glider,0,0);
        gameBoardExpected.addShape(gliderAtOneStep,1,0);
        gameBoardExpected.addShape(blinkerOscilated,7,4);
        BoolMatrixPrinter printedGameBoard = new BoolMatrixPrinter();
        String boardVisualizer=printedGameBoard.printMatrix(gameBoard);
        String boardExpected=printedGameBoard.printMatrix(gameBoardExpected);
//        System.out.println(boardVisualizer);

        while (i<1){
            gameBoard.step();
            boardVisualizer=printedGameBoard.printMatrix(gameBoard);
            //System.out.println(boardVisualizer);
            i++;
        }
        System.out.println(boardExpected);
        System.out.println(boardVisualizer);
        assertArrayEquals(gameBoard.getData(), gameBoardExpected.getData());

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
    /**
     * probably a lazy implementation but simply calculated where the shape would be and what the glider would look
     * like utilizing this website
     * https://playgameoflife.com/
     *
     */
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
//        System.out.println(boardVisualizer);

        while (i<10){
            gameBoard.step();
            boardVisualizer=printedGameBoard.printMatrix(gameBoard);
            //System.out.println(boardVisualizer);
            i++;
        }
//        System.out.println(boardExpected);
//        System.out.println(boardVisualizer);
        assertArrayEquals(gameBoard.getData(), gameBoardExpected.getData());

    }
}