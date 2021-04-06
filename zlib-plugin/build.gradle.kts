plugins {
    id("com.github.johnrengelman.shadow") version "6.1.0" // 全量打包插件
}

dependencies {
    implementation(project(":zlib-api"))

    compileOnly(Libs.spigot) // Spigot API
    compileOnly(Libs.bungeecord) // BC API

    // NMS
    compileOnly(Libs.nms_1_8_R3)
    compileOnly(Libs.nms_1_12_R1)
    compileOnly(Libs.nms_1_13_R2)
    compileOnly(Libs.nms_1_14_R1)
    compileOnly(Libs.nms_1_15_R1)
    compileOnly(Libs.nms_1_16_R1)
    compileOnly(Libs.nms_1_16_R2)
    compileOnly(Libs.nms_1_16_R3)
}

repositories {
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://realheart.gitee.io/maven")
}


tasks.processResources {
    // 替换版本
    from("src/main/resources/bungee.yml") {
        // BC插件版本
        filter { return@filter it.replace("\${version}", version.toString()) }
    }

    from("src/main/resources/plugin.yml") {
        // Bukkit插件版本
        filter { return@filter it.replace("\${version}", version.toString()) }
    }
}

tasks.build {
    // build时执行shadowJar任务
    dependsOn(tasks.shadowJar)
}


group = "me.zhenxin"
version = "1.0"
