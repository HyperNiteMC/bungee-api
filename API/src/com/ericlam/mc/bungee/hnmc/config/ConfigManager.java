package com.ericlam.mc.bungee.hnmc.config;

import net.md_5.bungee.config.Configuration;

/**
 * 指令管理器
 */
public interface ConfigManager {

    /**
     * 設置訊息 yml
     *
     * @param config 訊息 yml 名稱
     */
    void setMsgConfig(String config);

    /**
     *
     * @param config 訊息yml 名稱
     * @param prefix 前綴路徑
     */
    void setMsgConfig(String config, String prefix);

    /**
     * @param path 訊息路徑
     * @return 含 prefix 的訊息
     */
    String getMessage(String path);

    /**
     *
     * @param path 訊息路徑
     * @return 不含prefix的訊息
     */
    String getPureMessage(String path);

    /**
     *
     * @param path StringList 訊息路徑
     * @param prefix 是否每行添加前綴
     * @return 字符串
     */
    String[] getMessageList(String path, boolean prefix);

    /**
     *
     * @param config yml 名稱
     * @return 重載成功
     */
    boolean reloadConfig(String config);

    /**
     * @see #reloadConfig(String)
     * @return 是否全部重載成功
     */
    boolean reloadAllConfigs();

    /**
     * 獲取 yml
     * @param config yml 名稱
     * @return yml
     */
    Configuration getConfig(String config);

    /**
     * 獲取 Yml 設置器
     * @see ConfigSetter
     * @return Yml 設置器
     */
    ConfigSetter getConfigSetter();
}
