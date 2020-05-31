package com.dimka.core.command.system;

import com.dimka.core.command.Command;
import com.dimka.core.dto.Response;
import com.dimka.core.dto.ResponseStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component("screen")
public class GetScreenshotCommand implements Command {

    private WebClient.Builder builder;

    @Override
    public Mono<Response> execute(Object params) {
        return builder.build()
                .get()
                .uri("http://system/system/screenshot")
                .retrieve()
                .bodyToMono(byte[].class)
                .map(bytes -> new Response(ResponseStatus.JPG, bytes));
    }
}
