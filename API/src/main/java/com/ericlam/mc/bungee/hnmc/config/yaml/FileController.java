package com.ericlam.mc.bungee.hnmc.config.yaml;

import java.io.IOException;

public interface FileController {

    <T extends BungeeConfiguration> void save(T config) throws IOException;

    <T extends BungeeConfiguration> void reload(T config);

}
