package org.example;
/*
The purpose of this file is to handle the logic of adding shapes to our board and implementing the step logic
 */
public  class GameOfLife extends Matrix {
    /**
     * Constructing our board by specifically calling the matrix constructor rows,cols as without it would get
     * no parameterless constructor error
     * https://stackoverflow.com/questions/7187799/why-default-constructor-is-required-in-a-parent-class-if-it-has-an-argument-ed-c
     * @param rows
     * @param cols
     */
    GameOfLife(int rows,int cols){
        super(rows,cols);
    }

    /**
     * the following method takes a shapeMatrix and sets the bounds for our iterations.If the height and length of our
     * shape is too big we throw an exception.We iterate through the length of the shape and begin to fill out our
     * gameBoard with the values of the shape. If at any point our rowIter+X coordinate or colIter+y coordinate exeeds
     * the length of the board we through an error. else we continue setting the data
     * @param shapeName gives a shape object with name and matrix values
     * @param row y-axis to insert matrix
     * @param column x-axis to insert matrix
     */
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

    /**
     *initializes a newBoard in order to represent our new board after a step
     * for every cell on the board we call our helper method to count the amount of alive neighbors a cell has
     * we then initialize the board based on the conditionals to determine the state of the cell alive or dead
     * we then set our current board to the new board after checking every cell
     */
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

    /**
     * Private helper function that counts the alive cells around the specific cell we are at. If any of the cells are
     * invalid which is found at the border cells we continue the loop iteration to bypass the invalid cells.if we have
     * an alive neighbor we add it and after all neighbors have been checked we return alive cells
     * @param gameBoard pass our gameboard to the helper to access the matrix
     * @param row y coordinate
     * @param col x coordinate
     * given both coordinate that is the individual cell that we check for its alive neighbors
     * @return the amount of alive cells
     */
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
        String boardVisualizer = printedGameBoard.printMatrix(gameBoard);
        System.out.println(boardVisualizer);
        int i=0;
        while (true){
            gameBoard.step();
            boardVisualizer = printedGameBoard.printMatrix(gameBoard);
            System.out.println(boardVisualizer);
            i++;

        }


    }


}








