package org.example;

import java.util.Arrays;

public class MatrixOutlinePrinter implements MatrixPrinter {

    public String printMatrix(Matrix matrix) {
        char[][] matrixOutline = new char[matrix.rowLength()+2][matrix.colLength()+2]; //accounting for "+" cells in the board
        int matrixOutlineRowLength =matrixOutline.length; //defining our boundaries for loop
        int matrixOutlineColLength = matrixOutline[0].length;

        for (int rowIter = 0; rowIter<matrixOutlineRowLength; rowIter++){
            for(int colIter = 0; colIter < matrixOutlineColLength;colIter++){
                if((rowIter ==0 || rowIter==matrixOutlineRowLength-1) && (colIter == matrixOutlineColLength-1 || colIter == 0)){
                    matrixOutline[rowIter][colIter] = '+'; //conditional for corner cells
                } else if (rowIter==0|| rowIter == matrixOutlineRowLength-1) {
                    matrixOutline[rowIter][colIter] = '|';//conditional for vertical cells
                } else if (colIter==0 ||colIter== matrixOutlineColLength-1) {
                    matrixOutline[rowIter][colIter]='-'; //conditional for horizontal cells
                }
                else{
                    matrixOutline[rowIter][colIter] = rowPrinter(matrix,rowIter).charAt(colIter);
                }
            }
        }
        return Arrays.deepToString(matrixOutline); //matrix conversion into a string
    }
    protected String rowPrinter(Matrix matrix, int row){
        StringBuilder rowContent = new StringBuilder();
        for(int colIter=0;colIter< matrix.colLength();colIter++){
            rowContent.append(matrix.getData(row,colIter));
        }
        return rowContent.toString();
            }
        }
