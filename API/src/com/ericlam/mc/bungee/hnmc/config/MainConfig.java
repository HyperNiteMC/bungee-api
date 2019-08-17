package com.ericlam.mc.bungee.hnmc.config;

import net.md_5.bungee.config.Configuration;

public interface MainConfig {

    String getPrefix();

    String getNotPlayer();

    String getNoPermission();

    String getNoThisPlayer();

    void reloadConfig();

    /**
     * @return 獲取資料庫文件
     * @deprecated 即將過期
     */
    @Deprecated
    Configuration getDatabase();

    /**
     * @return Redis 資料
     */
    RedisData getRedisData();
}
