package me.zhenxin.zlib.mc.module.logger.impl

import me.zhenxin.zlib.ZLib
import me.zhenxin.zlib.mc.module.logger.ZLogger
import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent

class ZLoggerBC(private val name: String, private val sender: CommandSender) : ZLogger {


    override fun info(msg: String) =
        sender.sendMessage(TextComponent(ZLib.Logger.prefix + ChatColor.GREEN + msg))

    override fun debug(msg: String) {
        if (ZLib.Logger.debug)
            sender.sendMessage(TextComponent(ZLib.Logger.prefix + ChatColor.YELLOW + "[Debug] " + msg))
    }

    override fun error(msg: String) =
        sender.sendMessage(TextComponent(ZLib.Logger.prefix + ChatColor.RED + msg))

}
