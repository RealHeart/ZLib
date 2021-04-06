# ZLib

![][java] ![][kotlin] [![][release]](../../releases) [![][build-status]][build-link]

## 简介

Z系列插件支持库 功能如下

* HttpUtil
* VersionCheck
* MD5生成

## 反馈

* 提交 [Issues](../../issues)
* 加入交流群：[1032722724](https://jq.qq.com/?_wv=1027&k=5oIs7cc) 反馈

## 构建

1. 克隆

   > ```shell
   > git clone https://gitee.com/RealHeart/ZLib # Gitee-码云
   > ```
   > ```shell
   > git clone https://github.com/RealHeart/ZLib # Github
   > ```

2. 构建

   > ```shell
   > cd ZLib
   > gradlew clean build
   > ```

## 使用

1. 在[release](../../releases)页或[CI构建][build-link]下载最新版本

2. 放入服务端插件目录

3. 运行服务器

## 开发者

* maven

```xml
<dependency>
    <groupId>me.zhenxin</groupId>
    <artifactId>zlib-api</artifactId>
    <version>${zlib.version}</version>
</dependency>
```

* gradle

```kotlin
implementation("me.zhenxin:zlib-api:${zlib.version}")
```

## JavaDoc

[点击查看使用文档](https://zmusic.zhenxin.xyz/)


[java]: https://badgen.net/badge/Java/1.8/green

[kotlin]: https://badgen.net/badge/Kotlin/1.4.34/green

[release]: https://badgen.net/github/release/RealHeart/ZLib

[build-status]: https://badgen.net/jenkins/last-build/ci.zhenxin.xyz/job/Minecraft/job/ZLib/

[build-link]: https://ci.zhenxin.xyz/job/Minecraft/job/ZLib/
