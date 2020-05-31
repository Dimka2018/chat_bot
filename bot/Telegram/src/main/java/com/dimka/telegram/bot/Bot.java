package com.dimka.telegram.bot;

import com.dimka.telegram.core.CoreService;
import com.dimka.telegram.dto.Response;
import com.dimka.telegram.response.ResponseDispatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @NonNull
    private Map<String, ResponseDispatcher> responseDispatchers;

    @NonNull
    private final CoreService coreService;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        log.info(update.getMessage().getText());
        log.info(update.getMessage().getFrom().getId().toString());
        Response response = coreService.dispatchMessage(update.getMessage().getText().toLowerCase());
        responseDispatchers.get(response.getCode()).dispatchResponse(update, response)
                .forEach(this::sendMessage);
    }

    @SneakyThrows
    private void sendMessage(PartialBotApiMethod method) {
        if (method.getClass().equals(SendMessage.class)) {
            execute(((SendMessage)method));
        } else if (method.getClass().equals(SendPhoto.class)) {
            execute(((SendPhoto)method));
        } else {
            log.info(method.getClass().toString());
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
