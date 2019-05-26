package com.ericlam.mc.bungee.hnmc.commands;


import net.md_5.bungee.api.plugin.Plugin;

@Deprecated
public class MainCommand {
    private String command;
    private Plugin plugin;

    public MainCommand(String command, Plugin plugin) {
        this.command = command;
        this.plugin = plugin;
    }

    public String getCommand() {
        return command;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public boolean equals(String command, Plugin plugin) {
        return command.equals(this.command) && this.plugin.equals(plugin);
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        MainCommand mainCommand = (MainCommand) o;
        return mainCommand.getPlugin().equals(this.plugin) && mainCommand.command.equals(this.command);
    }

    @Override
    public int hashCode() {
        return plugin.hashCode() + this.command.hashCode();
    }
}
