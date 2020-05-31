package com.dimka.core.command.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CommandUtils {

   public CommandMetadata parseMessage(String message) {
        CommandMetadata metadata = new CommandMetadata();
        if (StringUtils.startsWith(message, "rotate")) {

        } else {
            metadata.setCommandName(message);
            metadata.setParams("");
        }
        return metadata;
    }
}
