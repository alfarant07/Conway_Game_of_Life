package org.example;

import java.util.Arrays;
/*
The following file is meant to print the outline of our board
 */

public class MatrixOutlinePrinter implements MatrixPrinter {
    /**
     * printMatrix takes in a matrix and constructs a new two dimmensional matrix of matrix.rowLength()+2 and colLength+2
     * this is necessary in order to account for the borders of the matrix. The function then iterates over the
     * matrixRowLength and matrixColLength we can then construct the border on the three conditionals. If none of the
     * conditionals are met we begin to fill our the content cells with the elements in our matrix. We then use
     * String builder that iterates through every row and column and builds a string representation of the row adds a
     * new line character and finally returns the string representation*
     * @param matrix gives a matrix objects and creates a string representation
     * @return the string version of our matrix
     */
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
            if(i==matrixOutline.length-1)break; //avoids redundant \n on last iteration
             formattedMatrix.append("\n");
        }
        return formattedMatrix.toString();
    }

    /**
     *  initializes every cell of our char array to an empty char
     * @param matrix takes a matrix and assigns the cell to a space
     * @param row needed for overwritten method which alters the data at row and column
     * @return the string representation of a row
     */
    protected String rowPrinter(Matrix matrix,int row){
        StringBuilder rowContent = new StringBuilder();
        for(int colIter=0;colIter< matrix.colLength();colIter++){
            rowContent.append(' ');
        }
        return rowContent.toString();
            }
        }
