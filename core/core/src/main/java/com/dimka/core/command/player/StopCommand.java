package com.dimka.core.command.player;

import com.dimka.core.command.Command;
import com.dimka.core.dto.Response;
import com.dimka.core.dto.ResponseStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component("stop")
public class StopCommand implements Command {

    private final WebClient.Builder builder;

    @Override
    public Mono<Response> execute(Object params) {
        return builder.build()
                .post()
                .uri("http://player/player/mode/off")
                .retrieve()
                .bodyToMono(Boolean.class)
                .map(status -> new Response(ResponseStatus.PLAYER_STATUS, status));
    }
}
