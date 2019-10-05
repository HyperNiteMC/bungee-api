package com.ericlam.mc.bungee.hnmc.config;

import com.ericlam.mc.bungee.hnmc.config.yaml.BungeeConfiguration;
import net.md_5.bungee.config.Configuration;

/**
 * 新的 Config 管理器
 */
public interface YamlManager {

    /**
     * 重載所有文件
     *
     * @return 成功
     */
    boolean reloadConfigs();

    /**
     * 重載單一文件
     *
     * @param yml 文件名稱
     * @return 成功
     */
    boolean reloadConfig(String yml);

    /**
     * 重載單一文件
     *
     * @param config 映射物件類
     * @param <T>    映射物件類
     * @return 成功
     */
    <T extends BungeeConfiguration> boolean reloadConfig(Class<T> config);

    /**
     * @param yml 文件名稱
     * @return 源文件
     * @deprecated 獲取源文件
     */
    @Deprecated
    Configuration getFileConfig(String yml);

    /**
     * 獲取源文件
     *
     * @param config 映射物件類
     * @return 源文件
     */
    Configuration getFileConfig(Class<? extends BungeeConfiguration> config);

    /**
     * @param yml 文件名稱
     * @param <T> 映射接口
     * @return 映射物件
     */
    <T extends BungeeConfiguration> T getConfig(String yml);

    /**
     * @param config 映射物件類
     * @param <T>    映射接口
     * @return 映射物件
     */
    <T extends BungeeConfiguration> T getConfigAs(Class<T> config);

    /**
     * @param path 路徑
     * @return 帶有 prefix 的訊息
     */
    String getMessage(String path);

    /**
     * @param path 路徑
     * @return 不帶 prefix 的訊息
     */
    String getPureMessage(String path);
}
