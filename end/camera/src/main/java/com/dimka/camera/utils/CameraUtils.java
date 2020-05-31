package com.dimka.camera.utils;

import com.github.sarxos.webcam.Webcam;
import lombok.SneakyThrows;

import java.awt.image.BufferedImage;

public class CameraUtils {

    @SneakyThrows
    public static BufferedImage getSnapshot(String cameraName) {
            Webcam webcam = Webcam.getWebcamByName(cameraName);
            webcam.open();
            BufferedImage image = webcam.getImage();
            webcam.close();
            return image;
    }
}
