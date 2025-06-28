package com.macbein.neuralnetwork;

import com.macbein.neuralnetwork.features.image.ImageConverter;
import com.macbein.neuralnetwork.features.neuraltypes.Perceptron;


public class Main {

    public static void main(String [] vararg) throws Exception {

        ImageConverter imageConverter = new ImageConverter();
        imageConverter.setHeight(5);
        imageConverter.setWidth(7);

        String [] paths = {
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/cero-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/uno-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/dos-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/tres-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/cuatro-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/cinco-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/seis-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/siete-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/ocho-35.png",
                "/Users/mya/workspaceSB/neural-networkin/src/main/resources/recognition-images/nueve-35.png"
        };

        double [][] inputs = new double [paths.length][];

        for(int i = 0; i < paths.length; i++){
            imageConverter.setPath(paths[i]);
            inputs[i] = imageConverter.imageToVector();
        }

        double [] labels = {1,0,0,0,0,0,0,0,0,0};

        Perceptron perceptron = new Perceptron(inputs[0].length,1);
        perceptron.train(inputs, labels, 10);
        imageConverter.setPath(paths[0]);
        System.out.println(perceptron.predict(imageConverter.imageToVector()));

    }

}
