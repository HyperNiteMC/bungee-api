package com.ericlam.mc.bungee.hnmc.config;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.util.*;

public abstract class ConfigSetter {

    private Plugin plugin;

    private List<String> configs = new ArrayList<>();

    /**
     * @param plugin  插件
     * @param configs yml 名稱
     */
    public ConfigSetter(Plugin plugin, String... configs) {
        this.plugin = plugin;
        this.configs.addAll(Arrays.asList(configs));
    }

    /**
     * 加載 yml
     * @param ymls 所有 yml 的 Map
     */
    public abstract void loadConfig(HashMap<String, Configuration> ymls);

    /**
     * 方便獲取用
     *
     * <p>
     *
     * 現已可 透過 @Extract 取代 此 方法。
     *
     * @see Extract
     *
     * @return 變數列表
     */
    public Map<String, Object> variablesMap() {
        return Map.of();
    }

    public List<String> getConfigs() {
        return configs;
    }


    public Plugin getPlugin() {
        return plugin;
    }
}
