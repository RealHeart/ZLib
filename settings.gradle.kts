rootProject.name = "ZLib"
include("zlib-api")
include("zlib-plugin")

pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/gradle-plugin")
    }
}
