package com.ericlam.mc.bungee.hnmc.main;

import com.ericlam.mc.bungee.hnmc.HyperNiteAPI;
import com.ericlam.mc.bungee.hnmc.SQLDataSource;
import com.ericlam.mc.bungee.hnmc.builders.function.ChatRunnerManager;
import com.ericlam.mc.bungee.hnmc.commands.caxerx.CommandRegister;
import com.ericlam.mc.bungee.hnmc.config.ConfigManager;
import com.ericlam.mc.bungee.hnmc.config.ConfigSetter;
import com.ericlam.mc.bungee.hnmc.config.MainConfig;
import com.ericlam.mc.bungee.hnmc.managers.ChatFormatManager;
import com.ericlam.mc.bungee.hnmc.managers.PlayerManager;

/**
 * 從這裏獲取所有 API
 */
public class HyperNiteMC implements HyperNiteAPI {

    public static HyperNiteAPI getAPI() {
        throw new RuntimeException("RUNTIME ERROR");
    }

    @Override
    public SQLDataSource getSQLDataSource() {
        throw new RuntimeException("RUNTIME ERROR");
    }

    @Override
    public ChatRunnerManager getChatRunnerManager() {
        throw new RuntimeException("RUNTIME ERROR");
    }

    @Override
    public CommandRegister getCommandRegister() {
        throw new RuntimeException("RUNTIME ERROR");
    }

    @Override
    public MainConfig getMainConfig() {
        throw new RuntimeException("RUNTIME ERROR");
    }

    @Override
    public ChatFormatManager getChatFormatManager() {
        throw new RuntimeException("RUNTIME ERROR");
    }

    @Override
    public PlayerManager getPlayerManager() {
        throw new RuntimeException("RUNTIME ERROR");
    }

    @Override
    public ConfigManager registerConfig(ConfigSetter setter) {
        throw new RuntimeException("RUNTIME ERROR");
    }
}
