package com.dimka.telegram.response;

import com.dimka.telegram.dto.Response;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public interface ResponseDispatcher {

    List<PartialBotApiMethod> dispatchResponse(Update update, Response response);
}
