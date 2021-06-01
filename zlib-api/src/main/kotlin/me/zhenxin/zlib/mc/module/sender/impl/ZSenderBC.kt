package me.zhenxin.zlib.mc.module.sender.impl

import me.zhenxin.zlib.mc.module.sender.MsgLevel
import me.zhenxin.zlib.mc.module.sender.MsgType
import me.zhenxin.zlib.mc.module.sender.ZSender
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent

/**
 * BC Sender
 *
 * @author 真心
 * @since 2021/6/1 12:24
 * @email qgzhenxin@qq.com
 */
class ZSenderBC(private val sender: CommandSender) : ZSender {
    override fun sendMsg(msg: String, type: MsgType, level: MsgLevel) {
        val msgLevel = when (level) {
            MsgLevel.NORMAL -> "§a"
            MsgLevel.WARN -> "§e"
            MsgLevel.ERROR -> "§c"
        }

        when (type) {
            MsgType.NORMAL -> sendNormalMsg(msgLevel + msg)
            MsgType.TITLE -> TODO()
            MsgType.JSON -> TODO()
        }
    }

    private fun sendNormalMsg(msg: String) {
        sender.sendMessage(TextComponent(msg))
    }

    private fun sendTitleMsg(msg: String){

    }

    private fun sendJsonMsg(msg: String){

    }
}
