package com.macbein.neuralnetwork.dependencyinjection.injector;

import com.macbein.neuralnetwork.dependencyinjection.application.Consumer;

public interface Injector {

    Consumer getConsumer();
}
