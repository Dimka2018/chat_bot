package com.dimka.camera.utils;

import com.github.sarxos.webcam.Webcam;

import java.awt.image.BufferedImage;

public class CameraUtils {

    public static BufferedImage getSnapshot() {
        return Webcam.getDefault().getImage();
    }
}
