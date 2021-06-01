package me.zhenxin.zlib

import me.zhenxin.zlib.mc.module.logger.impl.ZLoggerBukkit
import org.bukkit.plugin.java.JavaPlugin
import me.zhenxin.zlib.ext.logger

class ZLibBukkit : JavaPlugin() {

    override fun onEnable() {
        me.zhenxin.zlib.ext.logger = ZLoggerBukkit("§bZLib §e>>> ", server.consoleSender)
        ZLib.logo.forEach {
            me.zhenxin.zlib.ext.logger.info("§b$it")
        }
        me.zhenxin.zlib.ext.logger.info("\n")
        me.zhenxin.zlib.ext.logger.info("    §6v${description.version}  by ZhenXin\n")
    }
}
