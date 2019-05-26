package com.ericlam.mc.bungee.hnmc.commands.caxerx;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * 幫助訊息建造器
 *
 * @author caxerx
 */
public class HelpOutputBuilder {
    private ComponentBuilder layout;
    private String mainCommand;

    public HelpOutputBuilder(CommandNode mainCommandNode) {
        StringBuilder mainCommandBuilder = new StringBuilder(mainCommandNode.getAlias().get(0));
        CommandNode topNode = mainCommandNode;
        while (topNode.getParent() != null) {
            topNode = topNode.getParent();
            mainCommandBuilder.insert(0, topNode.getAlias().get(0) + " ");
        }
        mainCommand = mainCommandBuilder.toString();
        layout = new ComponentBuilder("");
        layout.append("===== ").append("/" + mainCommandNode.getCommand() + " 指令幫助").color(ChatColor.AQUA).append(" =====").color(ChatColor.RESET).append("\n");
    }

    public HelpOutputBuilder append(CommandNode res) {
        // /cs list - description of jj
        // /cs info <scroll_name> description of jj
        String cmd = "/" + mainCommand + " ";
        for (String ali : res.getAlias()) {
            if (ali.contains(" ")) {
                continue;
            }
            cmd += ali;
            break;
        }
        ClickEvent event;
        if (res.getPlaceholder() != null) {
            cmd = cmd + " " + res.getPlaceholder();
            event = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, cmd);
        } else {
            event = new ClickEvent(ClickEvent.Action.RUN_COMMAND, cmd);
        }
        layout.append(new ComponentBuilder(cmd).event(event).create()).append(" - ").color(ChatColor.GOLD).append(res.getDescription()).color(ChatColor.YELLOW).append("\n").reset();
        return this;
    }


    public TextComponent build() {
        return new TextComponent(layout.create());
    }

}
