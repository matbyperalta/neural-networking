package com.macbein.neuralnetwork.dependencyinjection.injector;

import com.macbein.neuralnetwork.dependencyinjection.application.ApplicationImageConverter;
import com.macbein.neuralnetwork.dependencyinjection.application.Consumer;
import com.macbein.neuralnetwork.features.image.ImageConverter;

public class ImageConverterInjector implements ServiceInjector{
    @Override
    public Consumer getConsumer() {
        return new ApplicationImageConverter(new ImageConverter());
    }
}
