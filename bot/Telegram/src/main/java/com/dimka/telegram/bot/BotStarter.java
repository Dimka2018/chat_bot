package com.dimka.telegram.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class BotStarter {

    private Bot chatBot;
    private TelegramBotsApi botsApi;


    @PostConstruct
    public void startUp() {
        try {
            botsApi.registerBot(chatBot);
            log.info("Telegram bot started");
        } catch (TelegramApiException e) {
            log.error(e);
        }
    }
}
