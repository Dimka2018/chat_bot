package com.dimka.core.command.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandMetadata {

    private String commandName;
    private Object params;
}
