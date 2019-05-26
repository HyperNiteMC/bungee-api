package com.ericlam.mc.bungee.hnmc.config;

import net.md_5.bungee.config.Configuration;

public interface MainConfig {

    String getPrefix();

    String getNotPlayer();

    String getNoPermission();

    String getNoThisPlayer();

    void reloadConfig();

    Configuration getDatabase();

}
