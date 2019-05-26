package com.ericlam.mc.bungee.hnmc.commands;

import com.ericlam.mc.bungee.hnmc.exception.ArgTooShortException;
import com.ericlam.mc.bungee.hnmc.exception.CommandNotFoundException;
import com.ericlam.mc.bungee.hnmc.exception.NoPermissionException;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * 指令處理器
 */
@Deprecated
public interface CommandHandle {

    /**
     * @param commandSender 指令發送者
     * @param strings       指令參數
     * @param command       指令
     * @param plugin        插件
     * @throws ArgTooShortException     參數不足
     * @throws CommandNotFoundException 找不到該分支指令
     * @throws NoPermissionException    沒有權限
     */
    void handle(CommandSender commandSender, String[] strings, Command command, Plugin plugin) throws ArgTooShortException, CommandNotFoundException, NoPermissionException;

    /**
     *
     * @param commandSender 指令發送者
     * @param command 指令
     * @param strings 指令參數
     * @param plugin 插件
     * @return Tab 列
     */
    Iterable<String> tapComplete(CommandSender commandSender, Command command, String[] strings, Plugin plugin);

}
