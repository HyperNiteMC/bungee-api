package com.ericlam.mc.bungee.hnmc;

import com.ericlam.mc.bungee.hnmc.builders.function.ChatRunnerManager;
import com.ericlam.mc.bungee.hnmc.commands.caxerx.CommandRegister;
import com.ericlam.mc.bungee.hnmc.config.ConfigManager;
import com.ericlam.mc.bungee.hnmc.config.ConfigSetter;
import com.ericlam.mc.bungee.hnmc.config.MainConfig;
import com.ericlam.mc.bungee.hnmc.managers.PlayerManager;

import java.io.IOException;

/**
 * 本服 API
 */
public interface HyperNiteAPI {

    SQLDataSource getSQLDataSource();

    ChatRunnerManager getChatRunnerManager();

    CommandRegister getCommandRegister();

    MainConfig getMainConfig();

    PlayerManager getPlayerManager();

    ConfigManager registerConfig(ConfigSetter setter) throws IOException;

}
