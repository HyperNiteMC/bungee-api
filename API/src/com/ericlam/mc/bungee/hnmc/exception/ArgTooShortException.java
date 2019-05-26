package com.ericlam.mc.bungee.hnmc.exception;

/**
 * @see com.ericlam.mc.bungee.hnmc.commands.caxerx.exception.CommandArgumentException
 */
@Deprecated
public class ArgTooShortException extends Exception {
    public ArgTooShortException(String cmd) {
        super(cmd);
    }
}
