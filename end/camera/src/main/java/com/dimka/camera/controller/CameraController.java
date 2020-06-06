package com.dimka.camera.controller;

import com.dimka.camera.utils.CameraManipulator;
import com.dimka.camera.utils.CameraUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class CameraController {

    private CameraManipulator manipulator;

    @Value("${camera.step}")
    private Integer angleStep;

    @Value("${camera.name}")
    private String cameraName;

    @Value("${camera.fps}")
    private Long fps;


    @GetMapping("/camera/snapshot")
    public void getImage(HttpServletResponse response) throws Exception {
        ImageIO.write(CameraUtils.getSnapshot(cameraName), "jpg", response.getOutputStream());
    }

    @GetMapping("/camera/video")
    public FileSystemResource getVideo(@PathVariable Long duration, HttpServletResponse response) {
        return new FileSystemResource(CameraUtils.getVideo(fps, duration, cameraName));
    }

    @PostMapping("/camera/angles/y")
    public void setCameraYAngle(@RequestBody Integer angle) {
        manipulator.setYAngle(angle);
    }

    @PostMapping("/camera/angles/z")
    public void setCameraZAngle(@RequestBody Integer angle) {
        manipulator.setZAngle(angle);
    }

    @PutMapping("/camera/angles/z/up")
    public void increaseZ() {
        manipulator.increaseZAngle(angleStep);
    }

    @PutMapping("/camera/angles/z/bottom")
    public void decreaseZ() {
        manipulator.decreaseZAngle(angleStep);
    }

    @PutMapping("/camera/angles/y/up")
    public void increaseY() {
        manipulator.increaseYAngle(angleStep);
    }

    @PutMapping("/camera/angles/y/bottom")
    public void decreaseY() {
        manipulator.decreaseYAngle(angleStep);
    }


}
