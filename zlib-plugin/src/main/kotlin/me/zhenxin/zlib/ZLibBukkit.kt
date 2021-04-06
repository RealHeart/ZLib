package me.zhenxin.zlib

import org.bukkit.plugin.java.JavaPlugin

class ZLibBukkit : JavaPlugin() {

    override fun onEnable() {
        ZLib.version = description.version
        ZLib.logo.forEach {
            server.logger.info("§bZLib §e>>> §b$it")
        }
        server.logger.info("§bZLib §e>>> \n")
        server.logger.info("§bZLib §e>>>     §6v${ZLib.version}  by ZhenXin\n")
    }
}
