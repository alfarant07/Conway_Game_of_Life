package org.example;

import java.util.Arrays;

public class MatrixOutlinePrinter implements MatrixPrinter {

    public String printMatrix(Matrix matrix) {
        char[][] matrixOutline = new char[matrix.rowLength()+2][matrix.colLength()+2];
        int matrixOutlineRowLength =matrixOutline.length;
        int matrixOutlineColLength = matrixOutline[0].length;

        for (int rowIter = 0; rowIter<matrixOutlineRowLength; rowIter++){
            for(int colIter = 0; colIter < matrixOutlineColLength;colIter++){
                if((rowIter ==0 || rowIter==matrixOutlineRowLength-1) && (colIter == matrixOutlineColLength-1 || colIter == 0)){
                    matrixOutline[rowIter][colIter] = '+';
                } else if (rowIter==0|| rowIter == matrixOutlineRowLength-1) {
                    matrixOutline[rowIter][colIter] = '|';
                } else if (colIter==0 ||colIter== matrixOutlineColLength-1) {
                    matrixOutline[rowIter][colIter]='-';
                }
            }
        }
        return Arrays.deepToString(matrixOutline);
    }
}
