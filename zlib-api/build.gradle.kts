plugins {
    id("org.jetbrains.dokka") version "1.4.32"
    `maven-publish`
    signing
}

repositories{
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://realheart.gitee.io/maven")
}

dependencies {
    implementation(Libs.zxing)
    implementation(Libs.hutool_core)

    implementation(Libs.okhttp)
    implementation(Libs.fastjson)

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

group = "me.zhenxin"
version = Version.zlib


tasks.test{
    enabled = false
}

tasks.dokkaHtml.configure {
    outputDirectory.set(File("${project.rootDir}/docs"))
}

tasks.dokkaJavadoc {
    outputDirectory.set(File("${project.rootDir}/docs/javadoc"))
}

tasks.register<Jar>("sourcesJar") {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

tasks.register<Jar>("javadocJar") {
    dependsOn("dokkaJavadoc")
    archiveClassifier.set("javadoc")
    from("${project.rootDir}/docs/javadoc")
}

artifacts {
    archives(tasks["sourcesJar"])
    archives(tasks["javadocJar"])
}

tasks.build {
    dependsOn(tasks.dokkaHtml)
    dependsOn(tasks.dokkaJavadoc)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "me.zhenxin"
            artifactId = tasks.jar.get().archiveBaseName.get()
            version = tasks.jar.get().archiveVersion.get()

            from(components["java"])

            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])

            pom {
                name.set("ZLib")
                description.set("ZhenXin's Minecraft Plugins Library")
                url.set("https://github.com/RealHeart/ZLib")
                licenses {
                    license {
                        name.set("GPLv3")
                        url.set("http://www.gnu.org/licenses/gpl-3.0.html")
                    }
                }
                developers {
                    developer {
                        id.set("zhenxin")
                        name.set("ZhenXin")
                        email.set("qgzhenxin@qq.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/RealHeart/ZLib.git")
                    developerConnection.set("scm:git:ssh://github.com/RealHeart/ZLib.git")
                    url.set("https://github.com/RealHeart/ZLib")
                }
            }
        }
    }
    repositories {
        maven {
            name = "local"
            url = uri("${project.rootDir}/build/repo")
        }
        maven {
            name = "sonatype"
            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            credentials {
                username = System.getenv("NEXUS_USERNAME") ?: properties["NEXUS_USERNAME"].toString()
                password = System.getenv("NEXUS_PASSWORD") ?: properties["NEXUS_PASSWORD"].toString()
            }
        }
    }
}

signing {
    sign(publishing.publications["maven"])
}
