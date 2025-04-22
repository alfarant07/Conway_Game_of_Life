package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixOutlinePrinterTest {

    @Test
    void printMatrix() {
        Matrix matrix = new Matrix(3, 4);
        MatrixPrinter printedMatrix = new MatrixOutlinePrinter();
        String result = printedMatrix.printMatrix(matrix);
        String expectedResult = "+----+\n" + "|    |\n" + "|    |\n" + "|    |\n" + "+----+";
        assertEquals(expectedResult, result);
    }

    @Test
    void BoolMatrixPrinter() {
        int[][] identityFail = {
                {1, 0},
                {0, 2}
        };
        Matrix matrix = new Matrix(identityFail);
        BoolMatrixPrinter boolMatrix = new BoolMatrixPrinter();
        assertThrows(IllegalArgumentException.class, () -> boolMatrix.printMatrix(matrix));
        Matrix matrixLength4 = new Matrix(4, 4);
        for (int i = 0; i < matrixLength4.rowLength(); i++) {
            for (int j = 0; j < matrixLength4.colLength(); j++) {
                if (i == j) matrixLength4.setData(i, j, 1);
            }
        }
        int[][] identity4x4 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Matrix expected = new Matrix(identity4x4);
        for (int i = 0; i < matrixLength4.rowLength(); i++) {
            for (int j = 0; j < matrixLength4.colLength(); j++) {
                assertEquals(matrixLength4.getData(i, j), expected.getData(i, j));//cant use assertArrayEquals so must
                //manually iterate over our matrix objects data
            }
        }
        Matrix matrix5x5 = new Matrix(5,5);
        int[][] expectedArray = {
                {1, 1, 1, 1,1},
                {0, 0, 0, 0,0},
                {0, 0, 0,0,0},
                {0, 0, 0,0,0},
                {1, 1, 1, 1,1}
        };
        Matrix expectedMatrix = new Matrix(expectedArray);
        assertEquals(expectedMatrix.rowLength(),matrix5x5.rowLength());

        for (int i = 0; i < matrix5x5.rowLength(); i++) {
            for (int j = 0; j < matrix5x5.colLength(); j++) {
                if (i == 0 || i==matrix5x5.rowLength()-1) matrix5x5.setData(i, j, 1);
            }
        }
        for (int i = 0; i < matrix5x5.rowLength(); i++) {
            for (int j = 0; j < matrix5x5.colLength(); j++) {
                assertEquals(expectedMatrix.getData(i,j),matrix5x5.getData(i,j));
            }
        }


    }
}



