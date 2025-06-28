package com.macbein.neuralnetwork.dependencyinjection.application;

import com.macbein.neuralnetwork.features.image.ImageConverter;

import java.io.IOException;

public class ApplicationImageConverter implements Consumer {

    private ImageConverter iImageConverter;

    public ApplicationImageConverter(ImageConverter iImageConverter){
        this.iImageConverter = iImageConverter;
    }

    @Override
    public void process() throws IOException {
        this.iImageConverter.imageToVector();
    }
}
