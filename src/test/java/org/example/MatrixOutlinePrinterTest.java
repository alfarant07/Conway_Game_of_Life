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
        Matrix resultMatrix = new Matrix(identity4x4);
        String expected = new String();
        expected = "+----+\n|1000|\n|0100|\n|0010|\n|0001|\n+----+";
        String result =boolMatrix.printMatrix(resultMatrix);
        assertEquals(expected,result);


//
//
  }
}



