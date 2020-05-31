package com.dimka.core.command;

import com.dimka.core.dto.Response;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.CorePublisher;
import reactor.core.publisher.Flux;

public interface Command {

    CorePublisher<Response> execute(Object params);
}
