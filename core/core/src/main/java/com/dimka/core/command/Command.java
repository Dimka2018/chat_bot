package com.dimka.core.command;

import reactor.core.publisher.Flux;

public interface Command {

    Flux<?> execute(Object params);
}
