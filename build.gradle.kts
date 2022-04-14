plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.14.0"
}


gradlePlugin {
    plugins {
        create("androidVersionManager") {
            group = "com.github.sh3lan93"
            version = "1.3"
            id = "com.github.sh3lan93.android-version-manager"
            displayName = "AndroidVersionManager"
            description =
                "A plugin for changing version code to be the last commit id if the project contains GIT " +
                        "or the current date if the project doesn't contain GIT"
            implementationClass = "com.shalan.VersionManagerPlugin"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    compileOnly("com.android.tools.build:gradle:7.1.3")
}

pluginBundle {
    vcsUrl = "https://github.com/sh3lan93/version-manager-android.git"
    website = "https://github.com/sh3lan93/version-manager-android"
    tags = listOf("android-plugin", "version-manager")
}
