Nextgen 简体中文插件（独立 Fabric/Meteor Addon）

目标版本：Minecraft 26.2 / Java 25 / Nextgen Client（mod id: meteor-client）

1. 先编译 Nextgen Client 主客户端。
2. 将主客户端构建出来的 JAR 复制到本插件 libs/Nextgen-Client.jar（新建 libs 文件夹）。
3. 在本插件目录执行 ./gradlew build（Windows: gradlew.bat build）。
4. 将 build/libs/Nextgen-ZH-Addon-1.0.0.jar 和 Nextgen Client 主 JAR 一起放进 Minecraft mods 文件夹。
5. 此插件仅翻译部分模块标题、设置标题和设置分组，不是完整汉化；模块内部 ID、命令、配置键保持英文。
6. 需要安装能显示中文的 Minecraft 字体资源（通常游戏自带）；插件不会修改游戏语言设置。
7. 本插件尚未在 Java 25 / 游戏内验证编译与加载。

说明：为避免破坏 Nextgen 的命令和旧配置，翻译只作用于显示字段。
