package com.macbein.neuralnetwork.linearalgebre;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Matrix {

    private int rows;
    private int cols;
    private double[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = cols;
        this.cols = cols;
        matrix = new double[rows][cols];
    }

    public Matrix(double[][] matrix){
        this.rows =  matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;
    }

    public void fillRandom(double multiplier){
        if(!isEmpty(this)){
            Random random = new Random();
            this.matrix = Arrays.stream(this.matrix)
                    .map(row -> Arrays.stream(row)
                            .map(values -> random.nextGaussian() * multiplier)
                            .toArray()).toArray(double[][]::new);
        }
    }

    public Matrix addScalar(double scalar){
        return new Matrix(Arrays.stream(this.matrix)
                .map(row -> Arrays.stream(row)
                    .map(value -> value + scalar)
                        .toArray()).toArray(double[][]::new));
    }

    public Matrix scalarProduct(double scalar){
        return new Matrix(Arrays.stream(this.matrix)
                .map(row -> Arrays.stream(row)
                        .map(value -> value * scalar)
                        .toArray()).toArray(double[][]::new));
    }

    public Matrix multiplyMatrices(Matrix matrix){
        if(isColEqualRow(this, matrix)){
            return new Matrix(IntStream.range(0, this.rows)
                    .mapToObj(i -> IntStream.range(0, matrix.cols)
                        .mapToDouble(j -> IntStream.range(0, this.cols)
                            .mapToDouble(k -> this.matrix[i][k] * matrix.matrix[k][j])
                            .sum()).toArray()).toArray(double[][]::new));
        }else{
            throw new IllegalArgumentException("Non-multiplyable matrices...");
        }
    }

    public double dotProduct(Matrix matrix){
        if(isEqualDimension(this, matrix)){
            return IntStream.range(0, this.matrix.length)
                    .mapToDouble(i -> IntStream.range(0, this.matrix[0].length)
                            .mapToDouble(j -> this.matrix[i][j] * matrix.matrix[i][j])
                            .sum()).sum();
        }else{
            throw new IllegalArgumentException("Non-multiplyable matrices...");
        }
    }

    public Matrix transposed(){
        Matrix transposed = new Matrix(this.cols, this.rows);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                transposed.matrix[j][i] = this.matrix[i][j];
            }

        }
        return transposed;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    private boolean isScalar(Matrix matrix){
        return matrix != null && matrix.matrix.length > 0
                && matrix.rows == 1 && matrix.cols == 1;
    }

    private boolean isEmpty(Matrix matrix){
        return matrix == null ||  matrix.matrix.length == 0;
    }

    private boolean isColEqualRow(Matrix matrix1, Matrix matrix2){
        return matrix1.matrix[0].length  == matrix2.matrix.length;
    }

    private boolean isEqualDimension(Matrix matrix1, Matrix matrix2){
        return matrix1.matrix.length == matrix2.matrix.length
                && matrix1.matrix[0].length == matrix2.matrix[0].length;
    }

    public void print(){
         for (double[] doubles : this.matrix) {
            for (int j = 0; j < doubles.length; j++) {
                System.out.print(doubles[j] + "  ");
            }
             System.out.println();
        }
    }

    public static void main(String [] varg){
        // Matriz original 2x3
       double[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] matrix2 = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        /*double[][] matrix2 = {
                {2}, {2}, {2}
        };*/

        /*double[][] matrix2 = {
                {1, 1, 1},
                {1, 1, 1}
        };*/

        /*double[][] matrix1 = {
                {1, 2},
                {3, 4}
        };

        double[][] matrix2 = {
                {4, 5},
                {6, 7}
        };*/

        Matrix matrix = new Matrix(matrix1);
        matrix.transposed().print();



    }
}
