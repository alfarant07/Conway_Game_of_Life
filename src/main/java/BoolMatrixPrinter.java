import org.example.Matrix;
import org.example.MatrixOutlinePrinter;

public class BoolMatrixPrinter extends MatrixOutlinePrinter {
    @Override
    protected String rowPrinter(Matrix matrix, int row){
        StringBuilder rowContent = new StringBuilder();
        for(int colIter=0;colIter< matrix.colLength();colIter++){
            if(matrix.getData(row,colIter) != 1 || matrix.getData(row,colIter)!=0){
                throw new IllegalArgumentException("Not a 0 or 1");
        }
            rowContent.append(matrix.getData(row,colIter));
        }
        return rowContent.toString();
    }
}
