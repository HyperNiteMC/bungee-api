package com.ericlam.mc.bungee.hnmc.config.yaml;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * 用於創建 Config class 時繼承
 */
public abstract class BungeeConfiguration {

    private Configuration configuration;
    private File outputSource;

    /**
     * 獲取源文件
     *
     * @return 源文件
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 保存源文件
     *
     * @return 成功
     */
    public boolean save() {
        Validate.notNull(configuration, "Configuration is null");
        Validate.notNull(outputSource, "OutputFile is null");
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, outputSource);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static class Validate {
        public static void notNull(Object obj, String msg) {
            Optional.ofNullable(obj).orElseThrow(() -> new IllegalStateException(msg));
        }
    }
}
