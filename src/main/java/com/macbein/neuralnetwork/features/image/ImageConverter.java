package com.macbein.neuralnetwork.features.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter implements IImageConverter {

    private String path;
    private int width;
    private int height;

    public double[] imageToVector() throws IOException {
        BufferedImage img = ImageIO.read(new File(path));
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        scaled.getGraphics().drawImage(img, 0, 0, width, height, null);
        double[] vector = new double[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = scaled.getRGB(x, y) & 0xFF;
                vector[y * width + x] = rgb / 255.0;
            }
        }
        return vector;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
