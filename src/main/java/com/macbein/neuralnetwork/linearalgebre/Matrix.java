package com.macbein.neuralnetwork.linearalgebre;

import java.util.Arrays;

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

    public Matrix addScalar(double scalar){
        return new Matrix(Arrays.stream(this.matrix)
                .map(row -> Arrays.stream(row)
                    .map(value -> value + scalar)
                        .toArray()).toArray(double[][]::new));
    }

    public Matrix multiplyScalar(double scalar){
        return new Matrix(Arrays.stream(this.matrix)
                .map(row -> Arrays.stream(row)
                        .map(value -> value * scalar)
                        .toArray()).toArray(double[][]::new));
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public static void main(String [] varg){
        // Matriz original 2x3
        double[][] matrixIn = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Matrix matrix = new Matrix(matrixIn);
        matrix.addScalar(2);

    }

    private boolean isScalar(Matrix matrix){
        return matrix != null && matrix.matrix.length > 0
                && matrix.rows == 1 && matrix.cols == 1;
    }

    private boolean isEmpty(Matrix matrix){
        return matrix == null || (matrix != null && matrix.matrix.length == 0);
    }
}
