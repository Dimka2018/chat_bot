package com.dimka.system.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SystemUtils {

    public static void shutDown() throws IOException {
        Runtime.getRuntime().exec("shutdown -s -t 0");
    }

    public static BufferedImage getScreenShot() throws Exception {
        return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }
}
