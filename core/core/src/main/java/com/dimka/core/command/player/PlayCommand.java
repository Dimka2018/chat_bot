package com.dimka.core.command.player;

import com.dimka.core.command.Command;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@ReactiveFeignClient("player")
public interface PlayCommand extends Command {

    @PostMapping("/player/mode/on")
    @Override
    Flux<?> execute(@RequestBody Object params);
}
