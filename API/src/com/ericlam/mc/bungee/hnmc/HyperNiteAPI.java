package com.ericlam.mc.bungee.hnmc;

import com.ericlam.mc.bungee.hnmc.builders.function.ChatRunnerManager;
import com.ericlam.mc.bungee.hnmc.commands.CommandHandle;
import com.ericlam.mc.bungee.hnmc.commands.CommandManager;
import com.ericlam.mc.bungee.hnmc.commands.caxerx.CommandRegister;
import com.ericlam.mc.bungee.hnmc.config.ConfigManager;
import com.ericlam.mc.bungee.hnmc.config.ConfigSetter;
import com.ericlam.mc.bungee.hnmc.config.MainConfig;

import java.io.IOException;

/**
 * 本服 API
 */
public interface HyperNiteAPI {

    SQLDataSource getSQLDataSource();

    ChatRunnerManager getChatRunnerManager();

    /**
     * <b>已過期。</b>
     *
     * @return Command Manager
     * @see CommandRegister
     */
    @Deprecated
    CommandManager getCommandManager();

    /**
     * <b>已過期</b>
     *
     * @return CommandHandle
     * @see com.ericlam.mc.bungee.hnmc.commands.caxerx.CommandNode
     */
    @Deprecated
    CommandHandle getCommandHandler();

    CommandRegister getCommandRegister();

    MainConfig getMainConfig();

    ConfigManager registerConfig(ConfigSetter setter) throws IOException;

}
