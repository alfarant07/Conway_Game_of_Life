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
        for(int rowIter =0;rowIter<shapeHeight;rowIter++){
            for(int colIter=0; colIter<shapeWidth;colIter++){
                this.setData(row+rowIter,colIter+colIter,shapeMatrix[rowIter][colIter]);
                        }
                    }
                }

    public void step(){
        int aliveCells =0;
        int[][] newBoard= new int[this.rowLength()][this.colLength()];
        for(int rowIter=0; rowIter<this.rowLength();rowIter++){
            aliveCells =0;
            for(int colIter=0; colIter<this.colLength();colIter++){
                for(int neighborRowIter = rowIter-1; neighborRowIter <rowIter+1; neighborRowIter++){
                    for(int neighborColIter = colIter-1; neighborColIter<colIter+1;neighborColIter++){
                        if(neighborRowIter<0 || neighborRowIter> this.rowLength() || neighborColIter<0 || neighborColIter>colLength())continue;
                        aliveCells+=this.getData(neighborRowIter,colIter);
                    }
                }
            }
        }
    }
            }






