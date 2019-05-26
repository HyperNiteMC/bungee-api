package com.ericlam.mc.bungee.hnmc.exception;

import com.ericlam.mc.bungee.hnmc.commands.SubCommand;
import com.ericlam.mc.bungee.hnmc.config.MainConfig;
import com.ericlam.mc.bungee.hnmc.main.HyperNiteMC;

public class NoPermissionException extends Exception {

    private String[] permissions;
    private boolean root;

    private MainConfig cf;

    public NoPermissionException(String permission) {
        super(permission);
        root = false;
        this.cf = HyperNiteMC.getAPI().getMainConfig();
    }

    public NoPermissionException(SubCommand subCommand) {
        super();
        this.cf = HyperNiteMC.getAPI().getMainConfig();
        permissions = subCommand.getSubCommands().stream().filter(sub -> sub.getPermission() != null).map(sub -> cf.getPrefix() + "§e" + sub.getPermission() + " §7- §a" + sub.getName()).toArray(String[]::new);
        root = true;
    }

    public String[] getPermissions() {
        return root ? permissions : new String[]{cf.getPrefix() + "§e" + this.getMessage()};
    }
}
