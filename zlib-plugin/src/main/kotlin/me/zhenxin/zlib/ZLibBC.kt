package me.zhenxin.zlib

import net.md_5.bungee.api.plugin.Plugin

class ZLibBC : Plugin() {

    override fun onEnable() {
        ZLib.version = description.version
        ZLib.logo.forEach {
            proxy.logger.info("§bZLib §e>>> §b$it")
        }
        proxy.logger.info("§bZLib §e>>> \n")
        proxy.logger.info("§bZLib §e>>>     §6v${ZLib.version}  by ZhenXin\n")
    }
}
