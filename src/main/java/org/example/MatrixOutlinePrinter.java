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
                    matrixOutline[rowIter][colIter] = '-';//conditional for vertical cells
                } else if (colIter==0 ||colIter== matrixOutlineColLength-1) {
                    matrixOutline[rowIter][colIter]='|'; //conditional for horizontal cells
                }
                else if(rowIter< matrix.rowLength()+1 && colIter<matrix.colLength()+1)  {
                    matrixOutline[rowIter][colIter] = rowPrinter(matrix,rowIter-1).charAt(colIter-1);
                    //assigns element to charAt returned string from rowPrinter. Quite verbose possible refactoring needed
                }
            }
        }
        StringBuilder formattedMatrix = new StringBuilder();
        for(int i =0; i<matrixOutline.length;i++){
            for(int j=0;j<matrixOutline[0].length; j++){
                formattedMatrix.append(matrixOutline[i][j]);
            }
            if(i==matrixOutline.length-1)break;
             formattedMatrix.append("\n");
        }
        return formattedMatrix.toString();
    }
    protected String rowPrinter(Matrix matrix, int row){
        StringBuilder rowContent = new StringBuilder();
        for(int colIter=0;colIter< matrix.colLength();colIter++){
            rowContent.append(' ');
        }
        return rowContent.toString();
            }
        }
