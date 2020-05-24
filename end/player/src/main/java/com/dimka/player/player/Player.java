package com.dimka.player.player;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

@Component
public class Player {

    private boolean active;
    private Clip clip;
    private AudioInputStream stream;

    public synchronized boolean play(String file) throws Exception {
        if (!active) {
            stream = AudioSystem.getAudioInputStream(new File(file));
            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            active = true;
        }
        return active;
    }

    public synchronized boolean stop() {
        if (active) {
            clip.stop();
            clip.close();
            active = false;
        }
        return active;
    }

    @SneakyThrows
    @PreDestroy
    public void closeStream() {
        stream.close();
    }
}
