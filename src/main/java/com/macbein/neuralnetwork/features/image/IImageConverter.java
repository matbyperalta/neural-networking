package com.macbein.neuralnetwork.features.image;

import java.io.IOException;

public interface IImageConverter {

    double[] imageToVector() throws IOException;
}
