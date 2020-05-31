package com.dimka.telegram.bot;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import javax.annotation.PostConstruct;

@Slf4j
@AllArgsConstructor
@Component
public class BotStarter {

    private final Bot chatBot;
    private final TelegramBotsApi botsApi;


    @SneakyThrows
    @PostConstruct
    public void startUp() {
        botsApi.registerBot(chatBot);
        log.info("Telegram bot started");
    }
}
