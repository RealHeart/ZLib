package me.zhenxin.zlib.mc.module.sender

/**
 * Sender
 *
 * @author 真心
 * @since 2021/6/1 12:23
 * @email qgzhenxin@qq.com
 */
interface ZSender {
    fun sendMsg(msg: String, type: MsgType = MsgType.NORMAL, level: MsgLevel = MsgLevel.NORMAL)


}

enum class MsgType {
    NORMAL,
    TITLE,
    JSON
}

enum class MsgLevel {
    NORMAL,
    WARN,
    ERROR
}
