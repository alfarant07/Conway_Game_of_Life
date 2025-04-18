package org.example;
public class Matrix {
    private int[][] data;

    public int[][] getData(){
        return data;
    }
    public void setData(int[][] matrix){
        this.data = matrix;
    }
        public Matrix(int rows, int columns) {
        if (rows < 1 || columns < 1) {throw new IllegalArgumentException("Invalid matrix size");}
        this.data = new int[rows][columns];
    }

    public Matrix(int[][] array){
        if(array ==null ) {
            throw new IllegalArgumentException("Invalid matrix");
        } else if (array.length<1 | array[0].length<1) {
            throw new IllegalArgumentException("Invalid matrix size");
        }
        this.data= array;
    }
    public int rowLength(){
        return data.length;
    }
    public int colLength(){
        return data[0].length;
    }



}
