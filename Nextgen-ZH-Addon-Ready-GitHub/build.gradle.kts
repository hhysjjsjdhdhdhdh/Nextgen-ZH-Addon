plugins { alias(libs.plugins.fabric.loom) }
version = "1.0.0"
group = "dev.nextgen"
base { archivesName = "Nextgen-ZH-Addon" }
repositories { mavenCentral(); maven("https://maven.meteordev.org/releases"); maven("https://maven.meteordev.org/snapshots") }
dependencies {
    minecraft(libs.minecraft)
    modImplementation(libs.fabric.loader)
    // Copy the locally built Nextgen Client jar into libs/ before building this addon.
    compileOnly(files("libs/Nextgen-Client.jar"))
}
java { toolchain.languageVersion.set(JavaLanguageVersion.of(25)) }
tasks.processResources { filesMatching("fabric.mod.json") { expand("version" to project.version) } }
