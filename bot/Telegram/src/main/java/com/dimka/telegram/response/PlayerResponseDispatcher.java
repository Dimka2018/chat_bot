package com.dimka.telegram.response;

import com.dimka.telegram.dto.Response;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Collections;
import java.util.List;

@Component("150")
public class PlayerResponseDispatcher implements ResponseDispatcher {

    @Override
    public List<PartialBotApiMethod> dispatchResponse(Update update, Response response) {
        String text = "Player status: " + (((Boolean) response.getContent()) ? "on" : "off");
        SendMessage message = new SendMessage()
                .setText(text)
                .setChatId(update.getMessage().getChatId());
        return Collections.singletonList(message);
    }
}
