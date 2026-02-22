package org.example;
/*
Matrix meant to hold our board
 */
public class Matrix {
    private int[][] data;

    /**
     *  Simple getter that retrives the entire two dim array
     * @return data
     */
    public int[][] getData(){
        return data;
    }

    /**
     *  A more specific getData method that allows us to get individual cells in our matrix
     * @param row y coordinate in our array
     * @param col x coordinate in our array
     * @return the element in data[x][y]
     */
    public int getData(int row, int col){
        return data[row][col];
    }

    /**
     * Assigns our data field to a two dimmensional matrix
     * @param matrix a two dimmensional array that we set our data field to
     */
    public void setData(int[][] matrix){
        this.data = matrix;
    }

    /**
     * A more specific setter that allows us to alter the individual cells of the data field
     * @param row y coordinate of the grid
     * @param col x coordinate of the grid
     * @param value the element we wish to insert
     */
    public void setData(int row, int col, int value){
        data[row][col] =value;
    }

    /**
     * Matrix constructor that takes the amount of rows and column and creates a matrix based on given dimmension
     * @param rows length of the grid
     * @param columns height of the grid
     * we get a grid of rows*height
     */
    public Matrix(int rows, int columns) {
        if (rows < 1 || columns < 1) {throw new IllegalArgumentException("Invalid matrix size");}
        this.data = new int[rows][columns]; //initializing data to given construct params
    }

    /**
     * Constructing a matrix object on a given twoDimmensional array
     * @param array utilized to assign our data field to the array
     */
    public Matrix(int[][] array){
        if(array ==null ) {
            throw new IllegalArgumentException("Invalid matrix");//catching invalid input
        } else if (array.length<1 | array[0].length<1) { //catching invalid size
            throw new IllegalArgumentException("Invalid matrix size");//throwing exception
        }
        this.data= array;//if inputs are good assign data->array
    }

    /**
     *
     * @return Returns the length of our Matrix
     */
    public int rowLength(){
        return data.length; //returning the length of our row data field
    }

    /**
     *
     * @return @return Returns the Height of our Matrix
     */
    public int colLength(){
        return data[0].length;
    }



}
