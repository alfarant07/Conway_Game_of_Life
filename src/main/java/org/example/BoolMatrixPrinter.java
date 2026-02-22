package org.example;
/*

The following file is meant to print our boolean matrix which represents our board
 */
public class BoolMatrixPrinter extends MatrixOutlinePrinter {
    /**
     * The following implementation of rowPrinter takes a matrix and a row. For each row we iterate through the column
     * length as that iterates through all elements in a given row. We build our string utilizing string builder
     * and ensure the matrix is filled with only 1's or 0's. We then return our string representation of the row.
     * @param matrix takes a matrix and assigns the cell to a space
     * @param row needed for overwritten method which alters the data at row and column
     * @return the string representation of the respective row
     */
    @Override
    protected String rowPrinter(Matrix matrix,int row){
        StringBuilder rowContent = new StringBuilder();//building string of the content row
        for(int colIter=0;colIter< matrix.colLength();colIter++){ //only need to iterate col as that gives us each value
            //in a given row
            if(matrix.getData(row,colIter) != 1 && matrix.getData(row,colIter)!=0){
                throw new IllegalArgumentException("Not a 0 or 1");
        }
            rowContent.append(matrix.getData(row,colIter));
        }
        return rowContent.toString();
    }
}
