package org.example;

public  class GameOfLife extends Matrix {
    GameOfLife(int rows,int cols){
        super(rows,cols);
    }
    public void addShape(Shape shapeName, int row, int column){
        int[][] shapeMatrix = shapeName.getData();
        int shapeHeight = shapeName.rowLength();
        int shapeWidth = shapeName.colLength();
        if(shapeHeight>this.rowLength() || shapeWidth>this.colLength())throw new IllegalArgumentException("Shape is too big");
        for(int rowIter =0;rowIter<shapeHeight;rowIter++){
            for(int colIter=0; colIter<shapeWidth;colIter++){
                if (rowIter + row >= this.rowLength() || colIter+column>=this.colLength()) {
                    throw new IllegalArgumentException("Shape is out of bounds");
                }
                    this.setData(rowIter + row, colIter + column, shapeMatrix[rowIter][colIter]);
                        }
                    }
                }

    public void step(){
        int[][] newBoard= new int[this.rowLength()][this.colLength()];
        for(int rowIter=0; rowIter<this.rowLength();rowIter++) {
            for (int colIter = 0; colIter < this.colLength(); colIter++) {
                int aliveCells = stepH(this,rowIter,colIter);
                int currentCell = this.getData(rowIter, colIter);
                if (currentCell == 1) {
                    if (aliveCells < 2 || aliveCells > 3) {
                        newBoard[rowIter][colIter] = 0;
                    }
                    if (aliveCells == 2 || aliveCells == 3) {
                        newBoard[rowIter][colIter] = 1;
                    }
                } else {
                    if (aliveCells == 3) {
                        newBoard[rowIter][colIter] = 1;
                    }
                }
            }


            }


        this.setData(newBoard);
    }
    private int stepH(Matrix gameBoard, int row, int col) {
        int aliveCells = 0;
        for (int neighborRowIter = row - 1; neighborRowIter <= row + 1; neighborRowIter++) {
            for (int neighborColIter = col - 1; neighborColIter <= col + 1; neighborColIter++) {
                if (neighborRowIter < 0 || neighborRowIter == this.rowLength() || neighborColIter < 0 || neighborColIter == this.colLength())
                    continue;
                if (neighborRowIter == row && neighborColIter == col) continue;
                aliveCells += gameBoard.getData(neighborRowIter, neighborColIter);

            }

        }
        return aliveCells;
    }
    public static void main(String[] args) {
        int[][] blinkerMatrix = {{ 1 },
                {1},
                {1}};

        Shape blinker = new Shape(name.Blinker,blinkerMatrix);
        int[][] gliderMatrix = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}};
        Shape glider = new Shape(name.Glider,gliderMatrix);
        GameOfLife gameBoard = new GameOfLife(10,10);
        gameBoard.addShape(blinker,5,5);
        gameBoard.addShape(glider,0,0);


        BoolMatrixPrinter printedGameBoard = new BoolMatrixPrinter();
        String boardVisualizer=printedGameBoard.printMatrix(gameBoard);
        System.out.println(boardVisualizer);
        int i=0;
        while (true){
            gameBoard.step();
            boardVisualizer=printedGameBoard.printMatrix(gameBoard);
            System.out.println( boardVisualizer);
            i++;

        }


    }


}








