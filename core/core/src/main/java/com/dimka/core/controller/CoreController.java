package com.dimka.core.controller;

import com.dimka.core.command.Command;
import com.dimka.core.command.utils.CommandMetadata;
import com.dimka.core.command.utils.CommandUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
public class CoreController {

    private final Map<String, Command> commands;
    private final CommandUtils commandUtils;

    @PostMapping(value = "/command", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<?> dispatchCommand(@RequestBody String message) {
        log.info(message);
        CommandMetadata metadata = commandUtils.parseMessage(message);
        log.info(commands.keySet().toString());
        Command command = commands.get(metadata.getCommandName());
        return command.execute(metadata.getParams());
    }
}
