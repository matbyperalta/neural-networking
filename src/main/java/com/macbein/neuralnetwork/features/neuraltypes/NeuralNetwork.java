package com.macbein.neuralnetwork.features.neuraltypes;

import java.util.Random;

public class NeuralNetwork {
    int inN, hidN, outN;
    double[][] wIH, wHO;
    double[] hidden, output;
    double lr = 0.5;

    public NeuralNetwork(int inN, int hidN, int outN) {

        initWeights();
    }

    void initWeights() {

    }

    double sigmoid(double x) { return 1.0/(1+Math.exp(-x)); }
    double sigDeriv(double y) { return y*(1-y); }


}
