package com.ericlam.mc.bungee.hnmc.exception;

public class ArgTooShortException extends Exception {
    public ArgTooShortException(String cmd) {
        super(cmd);
    }
}
