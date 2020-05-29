package com.dimka.player.controller;

import com.dimka.player.player.Player;
import com.dimka.player.utils.FileUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlayerController {

    @Value("${music.folder}")
    private String folderToPlay;

    @NonNull
    private final Player player;

    @PostMapping("/player/mode/on")
    public Boolean play() throws Exception {
        log.info("play");
        String file = FileUtils.getRandomFile(folderToPlay);
        return player.play(file);
    }

    @PostMapping("/player/mode/off")
    public Boolean stop() throws Exception {
        log.info("stop");
        return player.stop();
    }
}
