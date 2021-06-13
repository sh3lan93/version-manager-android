plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.14.0"
}

group "com.shalan"
version "1.0-SNAPSHOT"


gradlePlugin {
    plugins {
        create("androidVersionManager") {
            id = "com.shalan.android-version-manager"
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
    implementation("com.android.tools.build:gradle:4.2.1")
}

