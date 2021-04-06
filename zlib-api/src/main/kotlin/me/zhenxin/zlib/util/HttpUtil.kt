package me.zhenxin.zlib.util

import cn.hutool.http.HttpRequest
import cn.hutool.json.JSONUtil


/**
 * @author 真心
 * @date 2021/1/24 14:58
 * @email qgzhenxin@qq.com
 * @description: HTTP请求工具
 */
object HttpUtil {

    /**
     * POST提交类型
     */
    enum class PostType {
        /** JSON类型 */
        JSON,

        /** WebForm类型 */
        FORM
    }

    /**
     * 通过Get获取字符串
     *
     * @param url 链接
     */
    @JvmStatic
    fun get(url: String): String {
        return HttpRequest.get(url)
            .execute()
            .body()
    }

    /**
     * 通过Post获取字符串
     *
     * @param url 链接
     * @param body 提交数据
     * @param type 提交数据类型 默认JSON
     */
    @JvmStatic
    fun post(url: String, body: Map<String, Any>, type: PostType = PostType.JSON): String {
        val params: String
        when (type) {
            PostType.FORM -> {
                var tmp = ""
                body.forEach {
                    tmp = "${tmp}${it.key}=${it.value}&"
                }
                tmp = tmp.substring(0, tmp.length - 1)
                params = tmp
            }
            PostType.JSON -> {
                params = JSONUtil.toJsonStr(body)
            }
        }
        return HttpRequest.post(url)
            .body(params)
            .execute()
            .body()
    }

    /**
     * 下载文件
     *
     * @param url 链接
     * @param path 路径
     */
    @JvmStatic
    fun download(url: String, path: String) {
        HttpRequest.get(url)
            .execute()
            .bodyStream().saveData(path)
    }
}
