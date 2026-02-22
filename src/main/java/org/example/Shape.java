package org.example;

/**
 * enum values to represent name of shape implemented in this class
 */

enum name{
    Beehive,
    Boat,
    Blinker,
    Glider
}
public class Shape extends Matrix {
    private name name;
    private Matrix matrix;
    /**
     * The following function assigns a name to our shape and then calls the constructor on our int[][]matrix parameter
     * giving us a matrix object of our 2 dimmensional array representation
     * @param shapeName enum value of name
     * @param matrix a matrix containing our shape in binary
     */
    Shape(name shapeName, int[][] matrix) {
        super(matrix); // access Matrix constructor avoids no paramerteless constructor error
        for (int i = 0; i < this.rowLength(); i++) {
            for (int j = 0; j < this.colLength(); j++) {
                if (this.getData(i, j) != 0 && this.getData(i, j) != 1) {
                    throw new IllegalArgumentException("Not a valid matrix");
                }
            }
        }
        this.name = shapeName;
    }

    public static void main(String[] args) {
        int[][] behiveMatrix = {{0, 1, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 0}};
        int[][] boatMatrix = {{1, 1, 0},
                {1, 0, 1},
                {0,1,0}};

        Shape shapeBee = new Shape(org.example.name.Beehive,behiveMatrix);
        Shape shapeBoat = new Shape(org.example.name.Boat,boatMatrix);

        BoolMatrixPrinter boolMatrixPrinter = new BoolMatrixPrinter();
        System.out.println(boolMatrixPrinter.printMatrix(shapeBee));
        System.out.println(boolMatrixPrinter.printMatrix(shapeBoat));

    }
}
