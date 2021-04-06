import me.zhenxin.zlib.util.HttpUtil

/**
 * 测试
 *
 * @author 真心
 * @since 2021/4/7 2:57
 * @email qgzhenxin@qq.com
 */

fun main() {
    val result = HttpUtil.post(
        "https://mhy.zhenxin.xyz/auth/login/qrcode/query",
        mapOf(
            "device" to "0af9ad5b3f004e2ab582262438b5d9a4",
            "ticket" to "606585dde6af64230962e105"
        ),
        HttpUtil.PostType.JSON
    )
    println(result)
}
