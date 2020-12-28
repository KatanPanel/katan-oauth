dependencies {
    implementation(project(":oauth"))
    implementation(project(":oauth-discord"))
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    withType<Jar> {
        manifest {
            attributes["Implementation-Version"] = archiveVersion
        }
        archiveBaseName.set("katan-oauth-${project.name}")
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }
}