package com.ericlam.mc.bungee.hnmc.commands.caxerx.functional;

import com.ericlam.mc.bungee.hnmc.commands.caxerx.CommandNodeBuilder;
import net.md_5.bungee.api.CommandSender;

import java.util.List;

/**
 * @see CommandNodeBuilder
 */
@FunctionalInterface
public interface AdvCmdExecution<T, D extends CommandSender> {
    T execute(D sender, List<String> args);
}
