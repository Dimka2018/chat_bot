package com.dimka.core.command.utils;

import org.springframework.stereotype.Component;

@Component
public class CommandUtils {

   public CommandMetadata parseMessage(String message) {
        return new CommandMetadata(message, "");
    }
}
