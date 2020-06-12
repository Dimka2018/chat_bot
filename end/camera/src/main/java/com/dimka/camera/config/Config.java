package com.dimka.camera.config;

import arduino.Arduino;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    //@Value("${camera.arduino.com:null}")
    private String com;

    //@Value("${camera.arduino.rate:null}")
    private Integer rate;

    /*@Bean
    public Arduino arduino() {
        return new Arduino("COM3", 115200);
    }*/
}
