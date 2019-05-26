package com.ericlam.mc.bungee.hnmc.builders.function;

import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * @see com.ericlam.mc.bungee.hnmc.builders.MessageBuilder#run(ChatRunner)
 */
@FunctionalInterface
public interface ChatRunner {
    void run(ProxiedPlayer player);
}
