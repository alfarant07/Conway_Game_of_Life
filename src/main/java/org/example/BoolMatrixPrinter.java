package org.example;

public class BoolMatrixPrinter extends MatrixOutlinePrinter {
    @Override
    protected String rowPrinter(Matrix matrix, int row){
        StringBuilder rowContent = new StringBuilder();//building string of the content row
        for(int colIter=0;colIter< matrix.colLength();colIter++){ //only need to iterate col as that gives us each value
            //in a given row
            if(matrix.getData(row,colIter) != 1 || matrix.getData(row,colIter)!=0){
                throw new IllegalArgumentException("Not a 0 or 1");
        }
            rowContent.append(matrix.getData(row,colIter));
        }
        return rowContent.toString();
    }
}
