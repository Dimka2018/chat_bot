package com.dimka.player.controller;

import com.dimka.player.player.Player;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlayerController {

    @Value("${music.file}")
    private String fileToPlay;

    @NonNull
    private final Player player;

    @PostMapping("/player/mode/on")
    public Boolean play() throws Exception {
        log.info("play");
        return player.play(fileToPlay);
    }

    @PostMapping("/player/mode/off")
    public Boolean stop() throws Exception {
        log.info("stop");
        return player.stop();
    }
}
