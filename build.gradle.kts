import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10" // Kotlin JVM
}

allprojects {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        gradlePluginPortal()
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "16"
    }

    tasks.withType<JavaCompile>() {
        options.encoding = "UTF-8"
    }
}
