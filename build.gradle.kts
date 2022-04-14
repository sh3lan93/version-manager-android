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
                "A manager for manage changing/incrementing verion code and version name of an android application depending on build type"
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
