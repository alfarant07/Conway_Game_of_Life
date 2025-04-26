package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void rowLength() {
        Matrix matrix = new Matrix(50000,35);
        assertEquals(50000,matrix.rowLength());
        Matrix matrix1 = new Matrix(1,1);
        assertEquals(1,matrix1.rowLength());
    }
    @Test
    void colLength() {
        Matrix matrix = new Matrix(2500,500);
        assertEquals(500,matrix.colLength());
        Matrix matrix1 = new Matrix(1,1);
        assertEquals(1,matrix1.colLength());
    }
    @Test
    void matrixConstructor(){
        assertThrows(IllegalArgumentException.class, () ->new Matrix(0,0));
        assertThrows(IllegalArgumentException.class, () ->new Matrix(null));
        assertThrows(IllegalArgumentException.class, () ->new Matrix(0,2500));
    }
}