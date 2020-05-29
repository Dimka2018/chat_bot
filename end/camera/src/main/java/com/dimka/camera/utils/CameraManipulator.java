package com.dimka.camera.utils;

public interface CameraManipulator {

    void setYAngle(Integer angle);

    void setZAngle(Integer angle);

    void increaseYAngle(Integer angle);

    void decreaseYAngle(Integer angle);

    void increaseZAngle(Integer angle);

    void decreaseZAngle(Integer angle);
}
