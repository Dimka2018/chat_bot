package com.dimka.camera.controller;

import com.dimka.camera.utils.CameraManipulator;
import com.dimka.camera.utils.CameraUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@RestController
public class CameraController {

    private final CameraManipulator manipulator;

    @Value("${camera.step}")
    private Integer angleStep;

    @GetMapping("/camera/snapshot")
    public void getImage(HttpServletResponse response) throws Exception {
        ImageIO.write(CameraUtils.getSnapshot(), "jpg", response.getOutputStream());
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
