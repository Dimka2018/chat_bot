package com.dimka.camera.utils;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IPixelFormat;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;
import lombok.SneakyThrows;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CameraUtils {

    @SneakyThrows
    public static BufferedImage getSnapshot(String cameraName) {
        Webcam webcam = Webcam.getWebcams()
                .stream()
                .filter(cam -> cam.getName().startsWith(cameraName))
                .findFirst()
                .orElseGet(Webcam::getDefault);
        webcam.open();
        BufferedImage image = webcam.getImage();
        webcam.close();
        return image;
    }

    @SneakyThrows
    public static File getVideo(Long fps, Long duration, String cameraName) {

        IMediaWriter writer = ToolFactory.makeWriter(new File("video.ts").getName());
        Dimension size = WebcamResolution.QVGA.getSize();
        writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, size.width, size.height);

        Webcam webcam = Webcam.getWebcams()
                .stream()
                .filter(cam -> cam.getName().startsWith(cameraName))
                .findFirst()
                .orElseGet(Webcam::getDefault);
        webcam.setViewSize(size);
        webcam.open();

        long start = System.currentTimeMillis();

        for (int i = 0; i < fps * duration; i++) {
            BufferedImage image = ConverterFactory.convertToType(webcam.getImage(), BufferedImage.TYPE_3BYTE_BGR);
            IConverter converter = ConverterFactory.createConverter(image, IPixelFormat.Type.YUV420P);

            IVideoPicture frame = converter.toPicture(image, (System.currentTimeMillis() - start) * 1000);
            frame.setKeyFrame(i == 0);
            frame.setQuality(0);

            writer.encodeVideo(0, frame);

            Thread.sleep(1000 / fps);
        }

        writer.close();
        webcam.close();
        return new File("video.ts");
    }
}
