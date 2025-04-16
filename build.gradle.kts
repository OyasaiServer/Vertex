plugins {
    kotlin("jvm") version "2.2.0-Beta1"
    id("com.gradleup.shadow") version "9.0.0-beta12"
    id("com.ncorti.ktfmt.gradle") version "0.22.0"
}

group = "com.github.oyasaiserver"

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.5-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.0-Beta1")
}

kotlin { jvmToolchain(21) }

ktfmt { kotlinLangStyle() }

tasks.run {
    build { dependsOn("shadowJar") }

    processResources {
        val properties = mapOf("version" to version)
        inputs.properties(properties)
        filteringCharset = Charsets.UTF_8.name()
        filesMatching("paper-plugin.yml") { expand(properties) }
    }
}
