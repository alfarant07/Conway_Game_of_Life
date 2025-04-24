package org.example;

public class GameOfLife extends Matrix {
    public GameOfLife(int rows,int cols){
        super(rows,cols);
    }
    public void addShape(Shape shapeName, int row, int column){
        int[][] shapeMatrix = shapeName.getData();
        int shapeHeight = shapeName.rowLength();
        int shapeWidth = shapeName.colLength();
        if(shapeHeight>this.rowLength() || shapeWidth>this.colLength())throw new IllegalArgumentException("Shape is too big");
        for(int rowIter =0;rowIter<this.rowLength();rowIter++){
            for(int colIter=0; colIter<this.colLength();colIter++){
                this.setData(row+rowIter,colIter+colIter,shapeMatrix[rowIter][colIter]);
                        }
                    }
                }

            }






