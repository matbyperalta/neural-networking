package com.macbein.neuralnetwork.features.neuraltypes;

import java.util.Random;

public class NeuralNetwork {
    int inN, hidN, outN;
    double[][] wIH, wHO;
    double[] hidden, output;
    double lr = 0.5;

    public NeuralNetwork(int inN, int hidN, int outN) {
        this.inN = inN; this.hidN = hidN; this.outN = outN;
        wIH = new double[inN][hidN];
        wHO = new double[hidN][outN];
        hidden = new double[hidN];
        output = new double[outN];
        initWeights();
    }

    void initWeights() {
        Random r = new Random();
        for(int i=0;i<inN;i++) for(int j=0;j<hidN;j++) wIH[i][j] = r.nextGaussian()*0.1;
        for(int i=0;i<hidN;i++) for(int j=0;j<outN;j++) wHO[i][j] = r.nextGaussian()*0.1;
    }

    double sigmoid(double x) { return 1.0/(1+Math.exp(-x)); }
    double sigDeriv(double y) { return y*(1-y); }

    public double[] feedForward(double[] in) {
        for(int j=0;j<hidN;j++) {
            hidden[j]=0;
            for(int i=0;i<inN;i++) hidden[j]+=in[i]*wIH[i][j];
            hidden[j]=sigmoid(hidden[j]);
        }
        for(int k=0;k<outN;k++) {
            output[k]=0;
            for(int j=0;j<hidN;j++) output[k]+=hidden[j]*wHO[j][k];
            output[k]=sigmoid(output[k]);
        }
        return output;
    }

    public void train(double[] in, double[] target) {
        feedForward(in);
        double[] outErr = new double[outN], outDelta = new double[outN];
        for(int k=0;k<outN;k++) {
            outErr[k] = target[k] - output[k];
            outDelta[k] = outErr[k]*sigDeriv(output[k]);
        }
        double[] hidErr = new double[hidN], hidDelta = new double[hidN];
        for(int j=0;j<hidN;j++) {
            hidErr[j]=0;
            for(int k=0;k<outN;k++) hidErr[j]+=outDelta[k]*wHO[j][k];
            hidDelta[j]=hidErr[j]*sigDeriv(hidden[j]);
        }
        for(int j=0;j<hidN;j++)
            for(int k=0;k<outN;k++)
                wHO[j][k]+= lr * outDelta[k] * hidden[j];
        for(int i=0;i<inN;i++)
            for(int j=0;j<hidN;j++)
                wIH[i][j]+= lr * hidDelta[j] * in[i];
    }

    public int predict(double[] in) {
        double[] out = feedForward(in);
        int maxIdx = 0;
        for(int k=1;k<out.length;k++)
            if(out[k] > out[maxIdx]) maxIdx = k;
        return maxIdx + 1;
    }
}
