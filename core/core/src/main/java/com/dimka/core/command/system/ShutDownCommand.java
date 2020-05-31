package com.dimka.core.command.system;

import com.dimka.core.command.Command;
import com.dimka.core.dto.Response;
import com.dimka.core.dto.ResponseStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component("off")
public class ShutDownCommand implements Command {

    private final WebClient.Builder builder;

    @Override
    public Mono<Response> execute(Object params) {
        return builder.build()
                .post()
                .uri("http://system/system/state/shutdown")
                .retrieve()
                .bodyToMono(Void.class)
                .map(nothing -> new Response(ResponseStatus.NO_CONTENT, ""));
    }
}
