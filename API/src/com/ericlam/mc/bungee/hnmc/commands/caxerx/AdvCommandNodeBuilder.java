package com.ericlam.mc.bungee.hnmc.commands.caxerx;

import com.ericlam.mc.bungee.hnmc.builders.MessageBuilder;
import com.ericlam.mc.bungee.hnmc.commands.caxerx.exception.NotExecutableException;
import com.ericlam.mc.bungee.hnmc.commands.caxerx.functional.AdvCmdExecution;
import com.ericlam.mc.bungee.hnmc.config.MainConfig;
import com.ericlam.mc.bungee.hnmc.main.HyperNiteMC;
import net.md_5.bungee.api.CommandSender;

import java.util.List;

/**
 * 指令節點建造器
 *
 * @param <Sender> 發送者指定類別
 * @author Eric Lam
 * @see CommandNode
 */
public class AdvCommandNodeBuilder<Sender extends CommandSender> {

    private String command;
    private String permission;
    private String description;
    private String placeholder;
    private CommandNode parent;
    private String[] alias = new String[0];
    private AdvCmdExecution<List<String>, Sender> tabCompleterSender;
    private AdvCmdExecution<Boolean, Sender> cmdExecutorSender;

    /**
     * @param command 指令
     */
    public AdvCommandNodeBuilder(String command) {
        this.command = command;

    }

    /**
     * @param permission 權限
     * @return this
     */
    public AdvCommandNodeBuilder<Sender> permission(String permission) {
        this.permission = permission;
        return this;
    }

    /**
     * @param description 介紹
     * @return this
     */
    public AdvCommandNodeBuilder<Sender> description(String description) {
        this.description = description;
        return this;
    }

    /**
     * @param placeholder 用法
     * @return this
     */
    public AdvCommandNodeBuilder<Sender> placeholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    /**
     * @param parent 父類指令
     * @return this
     */
    public AdvCommandNodeBuilder<Sender> parent(CommandNode parent) {
        this.parent = parent;
        return this;
    }

    /**
     * 若果是主指令，將會自動從 plugin.yml 添加
     *
     * @param alias 縮寫指令
     * @return this
     */
    public AdvCommandNodeBuilder<Sender> alias(String... alias) {
        this.alias = alias;
        return this;
    }

    /**
     * @param executor tab 執行
     * @return this
     */
    public AdvCommandNodeBuilder<Sender> tabComplete(AdvCmdExecution<List<String>, Sender> executor) {
        this.tabCompleterSender = executor;
        return this;
    }

    /**
     * @param cmdExecutor 指令執行
     * @return this
     */
    public AdvCommandNodeBuilder<Sender> execute(AdvCmdExecution<Boolean, Sender> cmdExecutor) {
        this.cmdExecutorSender = cmdExecutor;
        return this;
    }

    /**
     * @return 指令節點
     * @throws NotExecutableException 指令無法執行
     */
    @SuppressWarnings("unchecked")
    public CommandNode build() {
        MainConfig config = HyperNiteMC.getAPI().getMainConfig();
        if (cmdExecutorSender == null) throw new NotExecutableException(command);
        return new CommandNode(parent, command, permission, description, placeholder, alias) {
            @Override
            public void executeCommand(CommandSender sender, List<String> args) {
                try {
                    cmdExecutorSender.execute((Sender) sender, args);
                } catch (ClassCastException e) {
                    MessageBuilder.sendMessage(sender, config.getPrefix() + config.getNotPlayer());
                }
            }

            @Override
            public List<String> executeTabCompletion(CommandSender sender, List<String> args) {
                try {
                    return tabCompleterSender == null ? null : tabCompleterSender.execute((Sender) sender, args);
                } catch (ClassCastException e) {
                    MessageBuilder.sendMessage(sender, config.getPrefix() + config.getNotPlayer());
                }
                return null;
            }
        };
    }


}
//如何使用
/*
class AdvCommandNodeUse{
    CommandNode getNode(){
        return new AdvCommandNodeBuilder<Player>("fly")
                .description("setfly")
                .execute((sender, args) -> {
                    sender.setAllowFlight(!sender.getAllowFlight());
                    sender.sendMessage("You "+(sender.getAllowFlight() ? "can" : "cannot")+" fly now.");
                    return true;
                }).build();
    }
}

 */



