package com.dimka.camera.utils;

import arduino.Arduino;
import com.dimka.camera.entity.Camera;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class ArduinoCameraManipulator implements CameraManipulator {

    @Value("${camera.arduino.com}")
    private String com;

    @Value("${camera.arduino.rate}")
    private Integer rate;

    private final Camera camera;
    private Arduino arduino;

    public ArduinoCameraManipulator(Camera camera) {
        this.arduino = new Arduino(com, rate);
        this.camera = camera;
    }

    @PostConstruct
    public void connect() {
        //arduino.openConnection();
    }

    @PreDestroy
    public void disconnect() {
        arduino.closeConnection();
    }

    @Override
    public Camera setYAngle(Integer angle) {
        return camera;
    }

    @Override
    public Camera setZAngle(Integer angle) {
        return camera;
    }

    @Override
    public Camera increaseYAngle(Integer angle) {
        return camera;
    }

    @Override
    public Camera decreaseYAngle(Integer angle) {
        return camera;
    }

    @Override
    public Camera increaseZAngle(Integer angle) {
        return camera;
    }

    @Override
    public Camera decreaseZAngle(Integer angle) {
        return camera;
    }

    private void sendMessage(String message) {
        arduino.serialWrite(message);
    }

    private String readMessage() {
        return arduino.serialRead();
    }
}
