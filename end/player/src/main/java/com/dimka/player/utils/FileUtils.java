package com.dimka.player.utils;

import java.io.File;

public class FileUtils {

    public static String getRandomFile(String folder) {
        int numberFiles = new File(folder).list().length - 1;
        String fileName = Math.round(Math.random() * numberFiles) + ".wav";
        return new File(folder + fileName).toString();
    }
}
