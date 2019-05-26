package com.ericlam.mc.bungee.hnmc.commands;


import com.ericlam.mc.bungee.hnmc.commands.caxerx.DefaultCommand;
import com.ericlam.mc.bungee.hnmc.exception.ArgTooShortException;
import com.ericlam.mc.bungee.hnmc.exception.CommandNotFoundException;
import com.ericlam.mc.bungee.hnmc.exception.NoPermissionException;
import com.ericlam.mc.bungee.hnmc.main.HyperNiteMC;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.TabExecutor;


/**
 * 快速預設指令的類。
 * <p>
 * 使用後無需處理指令及自動完成列，只需處理 Exception 即可。
 * <p>
 * <b>已過期。</b> 請使用 {@link com.ericlam.mc.bungee.hnmc.commands.caxerx.CommandRegister#registerCommand(DefaultCommand)} 進行主指令註冊
 *
 */
@Deprecated
public abstract class HNMCCommand extends Command implements TabExecutor {

    private Plugin plugin;
    private CommandHandle handle;


    /**
     *
     * @param name 指令名稱
     * @param plugin 插件
     */
    public HNMCCommand(String name, Plugin plugin) {
        super(name);
        this.plugin = plugin;
        this.handle = HyperNiteMC.getAPI().getCommandHandler();
    }


    /**
     *
     * @param plugin 插件
     * @param name 指令名稱
     * @param permission 權限
     * @param aliases 縮寫
     */

    public HNMCCommand(Plugin plugin, String name, String permission, String... aliases) {
        super(name, permission, aliases);
        this.plugin = plugin;
        this.handle = HyperNiteMC.getAPI().getCommandHandler();
    }


    /**
     * 已自動處理
     * @param commandSender 指令發送者
     * @param strings 指令參數
     */

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        try {
            handle.handle(commandSender, strings, this, plugin);
        } catch (ArgTooShortException e) {

            this.onArgTooShort(commandSender, e);
        } catch (CommandNotFoundException e) {
            this.onCommandNotFound(commandSender, e);
        } catch (NoPermissionException e) {
            this.onNoPermission(commandSender, e);
        }
    }


    @Override
    public Iterable<String> onTabComplete(CommandSender commandSender, String[] strings) {
        return handle.tapComplete(commandSender, this, strings, plugin);
    }


    /**
     *
     * @param sender 指令發送者
     * @param e 參數過短時
     */
    public abstract void onArgTooShort(CommandSender sender, ArgTooShortException e);

    /**
     *
     * @param sender 指令發送者
     * @param e 找不到指令時
     */
    public abstract void onCommandNotFound(CommandSender sender, CommandNotFoundException e);

    /**
     *
     * @param sender 指令發送者
     * @param e 沒有權限時
     */
    public abstract void onNoPermission(CommandSender sender, NoPermissionException e);
}
