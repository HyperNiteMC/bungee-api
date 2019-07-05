package com.ericlam.mc.bungee.hnmc.managers;

import com.ericlam.mc.bungee.hnmc.container.PlayerSkin;
import com.ericlam.mc.bungee.hnmc.exceptions.SkinUpdateTooFastException;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface SkinValueManager {

    /**
     * 更新玩家皮膚
     *
     * @param uuid 玩家UUID
     * @return 玩家皮膚
     * @throws SkinUpdateTooFastException 距離上次更新不夠一日拋出
     */
    CompletableFuture<PlayerSkin> updateSkin(UUID uuid) throws SkinUpdateTooFastException;

    /**
     * @param uuid 玩家UUID
     * @return 玩家皮膚
     */
    CompletableFuture<PlayerSkin> getOrSaveSkinForPlayer(UUID uuid);

    /**
     * @param uuid 玩家UUID
     * @param name 玩家名稱
     * @return 玩家皮膚
     */
    CompletableFuture<PlayerSkin> getOrSaveSkinForPlayer(UUID uuid, String name);

    /**
     * 刪除玩家皮膚資料
     *
     * @param uuid 玩家UUID
     * @return 是否存在
     */
    CompletableFuture<Boolean> dropSkin(UUID uuid);


    /**
     * 設置玩家皮膚
     *
     * @param player 玩家
     * @param value  base64 皮膚
     */
    void applySkin(final ProxiedPlayer player, final String value);

}
