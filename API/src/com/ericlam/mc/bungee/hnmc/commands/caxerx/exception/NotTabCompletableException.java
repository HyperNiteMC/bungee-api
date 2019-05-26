package com.ericlam.mc.bungee.hnmc.commands.caxerx.exception;

import com.ericlam.mc.bungee.hnmc.commands.caxerx.CommandNodeBuilder;

/**
 * 找不到自動完成 Tab
 *
 * @author Eric Lam
 * @see CommandNodeBuilder#build()
 */
public class NotTabCompletableException extends RuntimeException {
    private String command;

    public NotTabCompletableException(String command) {
        super("Tab 返回為 null");
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
