package com.ericlam.mc.bungee.hnmc.commands;

import com.ericlam.mc.bungee.hnmc.permission.Perm;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class SubCommand {

    private Plugin plugin;
    private MainCommand mainCommand;
    private Set<SubSubCommand> subCommands = new HashSet<>();

    public SubCommand(Plugin plugin) {
        this.plugin = plugin;
        mainCommand = new MainCommand(getParentCommand(), plugin);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public MainCommand getMainCommand() {
        return mainCommand;
    }

    public List<String> getTabList(CommandSender sender) {
        List<String> strings = subCommands.stream().filter(sub -> {
            String perm = sub.getSubPermissions().isEmpty() ? sub.getPermission() : null;
            return perm == null || Perm.hasPermission(sender, perm);
        }).map(SubSubCommand::getName).collect(Collectors.toList());
        return strings.isEmpty() ? null : strings;
    }

    public List<String> getTabList() {
        List<String> strings = subCommands.stream().map(SubSubCommand::getName).collect(Collectors.toList());
        return strings.isEmpty() ? null : strings;
    }

    public abstract String getParentCommand();

    public abstract int getArgs();

    public abstract String getHelpMessages();

    public abstract String getPermission();

    public abstract String getName();

    public abstract boolean runAsync();

    public abstract void execute(CommandSender sender, String[] args);

    public Set<String> getSubPermissions() {
        return subCommands.stream().map(sub -> sub.getPermission() != null ? sub.getPermission() : "").collect(Collectors.toSet());
    }

    public Set<SubSubCommand> getSubCommands() {
        return subCommands;
    }

    public Optional<SubSubCommand> getSubCommand(String subcmd) {
        return subCommands.stream().filter(subSubCommand -> subSubCommand.getName().equals(subcmd)).findAny();
    }

    public void addSubCommand(SubSubCommand subCommand) {
        boolean yes = subCommand.getParentCommand().equals(this.getName());
        if (!yes) {
            ProxyServer.getInstance().getLogger().warning("你正在把主指令為 " + subCommand.getParentCommand() + " 的分支指令加到 /" + this.getParentCommand() + " " + this.getName() + " 指令內。");
            ProxyServer.getInstance().getLogger().warning("You are putting " + subCommand.getParentCommand() + "'s child command into /" + this.getParentCommand() + " " + this.getName() + "");
            return;
        }
        subCommands.add(subCommand);
    }

    public String[] getSubHelpMessages() {
        String[] msgs = getSubCommands().stream().filter(subsub -> subsub.getHelpMessages() != null).map(SubCommand::getHelpMessages).toArray(String[]::new);
        if (msgs.length == 0) {
            return new String[]{"§c沒有你可以用的指令。"};
        } else return msgs;
    }

    public String[] getSubHelpMessages(CommandSender sender) {
        String[] msgs = getSubCommands().stream().filter(subsub -> subsub.getHelpMessages() != null).filter(subsub -> subsub.getPermission() == null || Perm.hasPermission(sender, subsub
                .getPermission())).map(SubCommand::getHelpMessages).toArray(String[]::new);
        if (msgs.length == 0) {
            return new String[]{"§c沒有你可以用的指令。"};
        } else return msgs;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        SubCommand cmd = (SubCommand) o;
        return cmd.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
