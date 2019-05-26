package com.ericlam.mc.bungee.hnmc.commands;

import com.ericlam.mc.bungee.hnmc.exception.ArgTooShortException;
import com.ericlam.mc.bungee.hnmc.exception.CommandNotFoundException;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.List;
import java.util.Set;

/**
 * 指令管理器
 */

public interface CommandManager {

    /**
     * 註冊分支指令
     *
     * @param subCommand 分支指令
     */
    void registerCommand(SubCommand subCommand);

    /**
     *
     * @param cmd 指令
     * @param plugin 插件
     * @return 主指令
     */
    MainCommand getMainCommand(String cmd, Plugin plugin);

    /**
     * 註冊分支指令及其分支
     * @param subCommand 分支指令
     * @param subsubCommand 其分支指令
     */
    void registerCommand(SubCommand subCommand, SubSubCommand... subsubCommand);

    /**
     * 獲取某分支指令
     * @param cmd 主指令文字
     * @param plugin 插件
     * @param subcommand 分支指令文字
     * @return 分支指令
     * @throws CommandNotFoundException 找不到指令
     */
    SubCommand getSubCommand(String cmd, Plugin plugin, String subcommand) throws CommandNotFoundException;

    /**
     * 獲取某分支指令的分支
     * @param cmd 指令
     * @param plugin 插件
     * @param subcommand 分支指令
     * @param args 參數位置
     * @return 其分支指令
     * @throws CommandNotFoundException 找不到指令
     * @throws ArgTooShortException 參數太短
     */
    SubSubCommand getSubSubCommand(String cmd, Plugin plugin, String subcommand, int args) throws CommandNotFoundException, ArgTooShortException;

    /**
     * 獲取所有分支指令
     * @return 所有分支指令
     */
    List<SubCommand> getAllSubCommands();

    /**
     * 獲取主指令的所有分支指令
     * @param cmd 主指令
     * @param plugin 插件
     * @return 其分支指令
     * @throws CommandNotFoundException 找不到指令
     */
    Set<SubCommand> getAllSubCommands(String cmd, Plugin plugin) throws CommandNotFoundException;
}
