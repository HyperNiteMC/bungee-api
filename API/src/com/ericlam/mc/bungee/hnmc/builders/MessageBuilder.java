package com.ericlam.mc.bungee.hnmc.builders;

import com.ericlam.mc.bungee.hnmc.builders.function.ChatRunner;
import com.ericlam.mc.bungee.hnmc.main.HyperNiteMC;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.*;

import java.util.UUID;

/**
 * 訊息建造器
 *
 * @see AdvMessageBuilder
 */
public class MessageBuilder {
    private ComponentBuilder componentBuilder;

    /**
     *
     * @param msg 原始訊息
     */
    public MessageBuilder(String msg) {
        String amsg = ChatColor.translateAlternateColorCodes('&', msg);
        componentBuilder = new ComponentBuilder(amsg);
    }

    public MessageBuilder() {
        componentBuilder = new ComponentBuilder("");
    }

    /**
     *
     * @param msgs 原始訊息串
     */
    public MessageBuilder(String... msgs) {
        componentBuilder = new ComponentBuilder("");
        for (String omsg : msgs) {
            String msg = ChatColor.translateAlternateColorCodes('&', omsg);
            componentBuilder.append(TextComponent.fromLegacyText(msg));
        }
    }

    /**
     *
     * @param sender 指令發送者
     * @param message 訊息
     */
    public static void sendMessage(CommandSender sender, String message) {
        String msg = ChatColor.translateAlternateColorCodes('&', message);
        sender.sendMessage(TextComponent.fromLegacyText(msg));
    }

    /**
     *
     * @param msg 訊息
     * @return this
     */
    public MessageBuilder add(String msg) {
        String amsg = ChatColor.translateAlternateColorCodes('&', msg);
        componentBuilder.append(TextComponent.fromLegacyText(amsg));
        return this;
    }

    /**
     *
     * @param msgs 訊息串
     * @return this
     */
    public MessageBuilder add(String... msgs) {
        for (String omsg : msgs) {
            String msg = ChatColor.translateAlternateColorCodes('&', omsg);
            componentBuilder.append(TextComponent.fromLegacyText(msg));
        }
        return this;
    }

    /**
     * 新增可點擊網址
     * @param website 網址
     * @return this
     */
    public MessageBuilder url(String website) {
        componentBuilder.event(new ClickEvent(ClickEvent.Action.OPEN_URL, website));
        return this;
    }

    /**
     * 新增可點擊預輸入指令
     * @param command 指令
     * @return this
     */
    public MessageBuilder suggest(String command) {
        componentBuilder.event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, command));
        return this;
    }

    /**
     * 新增可點擊運行指令
     * @param command 指令
     * @return this
     */
    public MessageBuilder command(String command) {
        componentBuilder.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        return this;
    }

    /**
     * 新增可點擊翻頁
     * @param page 頁數
     * @return this
     */
    public MessageBuilder page(String page) {
        componentBuilder.event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, page));
        return this;
    }

    /**
     * 新增可見氣泡文字
     * @param texts 文字串
     * @return this
     */
    public MessageBuilder hoverText(String... texts) {
        ComponentBuilder builder = new ComponentBuilder("");
        for (String omsg : texts) {
            String msg = ChatColor.translateAlternateColorCodes('&', omsg);
            builder.append(msg);
        }
        componentBuilder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, builder.create()));
        return this;
    }

    /**
     * 新增可見成就訊息
     * @param achievementNode 成就節點
     * @return this
     */
    public MessageBuilder showAdvancement(String achievementNode) {
        String value = "\"value\":" + achievementNode;
        componentBuilder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(value)));
        return this;
    }

    /**
     * 新增shift click 文字
     * @param insert 文字
     * @return this
     */
    public MessageBuilder insertWhenShiftClick(String insert) {
        componentBuilder.insertion(insert);
        return this;
    }

    /**
     * 換行
     * @return this
     */
    public MessageBuilder nextLine() {
        componentBuilder.append("\n");
        return this;
    }

    /**
     * 新增可點擊的運行
     * @param runner 運行函式
     * @return this
     */
    public MessageBuilder run(ChatRunner runner) {
        UUID id = UUID.randomUUID();
        this.command("/command-run_" + id.toString());
        HyperNiteMC.getAPI().getChatRunnerManager().register(id, runner);
        return this;
    }

    /**
     * 新增可點擊的運行
     *
     * @param timeoutSeconds 過期時間 (秒)
     * @param runner         運行函式
     * @return this
     */
    public MessageBuilder run(int timeoutSeconds, ChatRunner runner) {
        UUID id = UUID.randomUUID();
        this.command("/command-run_" + id.toString());
        HyperNiteMC.getAPI().getChatRunnerManager().register(id, runner, timeoutSeconds);
        return this;
    }

    /**
     *
     * @return 訊息
     */
    public BaseComponent[] build() {
        return componentBuilder.create();
    }

    /**
     *
     * @param player 玩家
     */
    public void sendPlayer(CommandSender player) {
        player.sendMessage(componentBuilder.create());
    }


}
//如何使用
/*
class MessageBuilderUse{
    void use(Player sender){
        BaseComponent[] msg = new MessageBuilder("&e[ 公告全世界你是女裝大佬 ]").hoverText("&a來啊點我啊").run(player -> {
            Bukkit.broadcastMessage(net.md_5.bungee.api.ChatColor.AQUA + player.getName()+" 是女裝大佬！！");
            BaseComponent[] tp = new MessageBuilder("&e[ 點我傳送到「她」的位置 ]").hoverText("&a點啊快點啊").run(player1 -> {
                player1.teleport(player);
            }).build();
            Bukkit.getOnlinePlayers().forEach(p->p.sendMessage(tp));
        }).build();
        sender.sendMessage(msg);
    }
}

 */
