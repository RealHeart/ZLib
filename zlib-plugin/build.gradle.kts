plugins {
    id("com.github.johnrengelman.shadow") version "6.1.0" // 全量打包插件
}

dependencies {
    implementation(project(":zlib-api"))

    compileOnly(Libs.spigot) // Spigot API
    compileOnly(Libs.bungeecord) // BC API
}

repositories {
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
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
version = Version.zlib
