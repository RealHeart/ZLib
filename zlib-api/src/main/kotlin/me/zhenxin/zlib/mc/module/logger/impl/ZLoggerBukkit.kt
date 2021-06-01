package me.zhenxin.zlib.mc.module.logger.impl

import me.zhenxin.zlib.mc.module.logger.ZLogger
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

class ZLoggerBukkit(private val prefix: String, private val sender: CommandSender) : ZLogger {

    override fun info(msg: String) =
        println(prefix + ChatColor.GREEN + msg)

    override fun debug(msg: String) {
        println(prefix + ChatColor.YELLOW + "[Debug] " + msg)
    }

    override fun error(msg: String) =
        println(prefix + ChatColor.RED + msg)
}
