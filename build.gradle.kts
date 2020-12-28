plugins {
    kotlin("jvm") version "1.4.21"
}

val artifactGroup = "me.devnatan.katan.oauth"
val artifactVersion = "0.0.1"
group = artifactGroup
version = artifactVersion

allprojects {
    group = artifactGroup
    version = artifactVersion

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        mavenLocal()
        jcenter()
        maven("http://nexus.devsrsouza.com.br/repository/maven-public/")
    }

    dependencies {
        compileOnly(kotlin("stdlib"))
        compileOnly("me.devnatan.katan:api:1.0.0-alpha.1")
    }
}