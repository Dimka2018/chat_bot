package com.dimka.camera.utils;

import com.dimka.camera.entity.Camera;

public interface CameraManipulator {

    Camera setYAngle(Integer angle);

    Camera setZAngle(Integer angle);

    Camera increaseYAngle(Integer angle);

    Camera decreaseYAngle(Integer angle);

    Camera increaseZAngle(Integer angle);

    Camera decreaseZAngle(Integer angle);
}
