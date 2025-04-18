public class Matrix {
    private int[][] data;

    public int[][] getData(){
        return data;
    }
    public void setData(int[][] matrix){
        this.data = matrix;
    }
//        public Matrix(int rows, int columns) {
//        if (rows < 1 || columns < 1) {throw new IllegalArgumentException("Invalid matrix size");}
//        this.data = new int[rows][columns];
//    }
//
//    public Matrix(int[][] array){
//        if(array ==null ) {
//            throw new IllegalArgumentException("Invalid matrix");
//        } else if (rowLength(array)<1 || colLength(array)<1) {
//            throw new IllegalArgumentException("Invalid matrix size");
//        }
//        this.data= array;
//    }
    public int rowLength(int[][] matrix){
        return matrix.length;
    }
    public int colLength(int[][] matrix){
        return matrix[0].length;
    }



}
