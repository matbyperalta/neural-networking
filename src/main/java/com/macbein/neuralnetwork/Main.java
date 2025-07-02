package com.macbein.neuralnetwork;

import com.macbein.neuralnetwork.features.image.ImageConverter;
import com.macbein.neuralnetwork.features.neuraltypes.Perceptron;


public class Main {

    public static void main(String [] vararg) throws Exception {

        ImageConverter imageConverter = new ImageConverter();
        imageConverter.setHeight(500);
        imageConverter.setWidth(500);

        String [] paths = {
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/cero.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/uno.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/dos.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/tres.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/cuatro.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/cinco.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/seis.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/siete.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/ocho.png",
                "/Users/mya/workspaceSB/neural-networking/src/main/resources/recognition-images/nueve.png"
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
