package com.dimka.core.command.player;

import com.dimka.core.command.Command;
import lombok.ToString;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@ToString
@Component("stop")
public class StopCommand implements Command {

    @Override
    public Flux<?> execute(Object params) {
        return Flux.just("stop");
    }
}
