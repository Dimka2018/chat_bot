package com.dimka.core.command.system;

import com.dimka.core.command.Command;
import com.dimka.core.dto.Response;
import com.dimka.core.dto.ResponseStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component("video")
public class GetVideoCommand implements Command {

    private WebClient.Builder builder;

    @Override
    public Mono<Response> execute(Object params) {
        return builder.build()
                .get()
                .uri("http://system/system/video?duration=" + params)
                .retrieve()
                .bodyToMono(byte[].class)
                .map(bytes -> new Response(ResponseStatus.JPG, bytes));
    }
}
