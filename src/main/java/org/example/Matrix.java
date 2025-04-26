package org.example;
public class Matrix {
    private int[][] data;
    public int[][] getData(){
        return data;
    }
    public int getData(int row, int col){
        return data[row][col];
    }
    public void setData(int[][] matrix){
        this.data = matrix;
    }
    public void setData(int row, int col, int value){
        data[row][col] =value;
    }

    public Matrix(int rows, int columns) {
        if (rows < 1 || columns < 1) {throw new IllegalArgumentException("Invalid matrix size");}
        this.data = new int[rows][columns]; //initializing data to given construct params
    }

    public Matrix(int[][] array){
        if(array ==null ) {
            throw new IllegalArgumentException("Invalid matrix");//catching invalid input
        } else if (array.length<1 | array[0].length<1) { //catching invalid size
            throw new IllegalArgumentException("Invalid matrix size");//throwing exception
        }
        this.data= array;//if inputs are good assign data->array
    }
    public int rowLength(){
        return data.length; //returning the length of our row data field
    }
    public int colLength(){
        return data[0].length;
    }



}
