package com.dimka.telegram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@Configuration
public class Config {

    @Bean
    public TelegramBotsApi botsApi() {
        return new TelegramBotsApi();
    }
}
