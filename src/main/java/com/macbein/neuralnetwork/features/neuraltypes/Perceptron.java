package com.macbein.neuralnetwork.features.neuraltypes;

import java.util.Random;

public class Perceptron {

    private int inN;
    private double bias;
    private double[] weights;
    private double learningRate = 0.1;

    public Perceptron(int inN, double bias){
        this.inN = inN;
        this.bias = bias;
        this.weights = new double[inN];
        initWeight();
    }

    private void initWeight(){
        Random random = new Random();
        for(int i=0; i<inN; i++){
            weights[i] = random.nextGaussian() * 0.1;
        }
    }

    private int activation(double weightedSum){
        return weightedSum >= 0 ? 1:0;
    }

    public double predict(double[] input) {
        double sum = bias;
        for (int i = 0; i < input.length; i++) {
            sum += weights[i] * input[i];
        }
        return activation(sum);
    }

    public void train(double [][] inputs, double [] labels, int epochs){
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                double prediction = predict(inputs[i]);
                double error = labels[i] - prediction;

                for (int j = 0; j < weights.length; j++) {
                    weights[j] += learningRate * error * inputs[i][j];
                }
                bias += learningRate * error;
            }
        }
    }

}
