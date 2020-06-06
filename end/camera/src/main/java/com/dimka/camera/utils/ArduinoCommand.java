package com.dimka.camera.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ArduinoCommand {

    private String axis;
    private Integer angle;
}
