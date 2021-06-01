package me.zhenxin.zlib

import me.zhenxin.zlib.mc.module.logger.impl.ZLoggerBC
import net.md_5.bungee.api.plugin.Plugin

class ZLibBC : Plugin() {

    override fun onEnable() {
        me.zhenxin.zlib.ext.logger = ZLoggerBC("§bZLib §e>>> ", proxy.console)
        ZLib.logo.forEach {
            me.zhenxin.zlib.ext.logger.info("§bZLib §e>>> §b$it")
        }
        me.zhenxin.zlib.ext.logger.info("\n")
        me.zhenxin.zlib.ext.logger.info("    §6v${description.version}  by ZhenXin\n")
    }
}
