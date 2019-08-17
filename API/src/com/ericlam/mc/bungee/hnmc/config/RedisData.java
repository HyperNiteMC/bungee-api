package com.ericlam.mc.bungee.hnmc.config;

public interface RedisData {

    String getHost();

    int getPort();

    int getTimeout();

    boolean usePassword();

    String getPassword();

}
