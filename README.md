![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/com.github.sh3lan93.android-version-manager?style=for-the-badge)

# Android Versions Manager

Gradle plugin for changing `versionCode` to be the last commit id if the project contains GIT or the current date if the project doesn't contain GIT

### How to use 

##### Plugins DSL
<details open>
  <summary>Kotlin</summary>

```kotlin
plugins {
  id("com.github.sh3lan93.android-version-manager") version "<latest version>"
}
```
</details>
Replace latest version with the version number
<details>
  <summary>Groovy</summary>

```groovy
plugins {
  id "com.github.sh3lan93.android-version-manager" version "<latest version>"
}
```
</details>
Replace latest version with the version number
  
##### Legacy 

<details open>
  <summary>Kotlin</summary>

```kotlin
buildscript {
  repositories {
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    classpath("com.github.sh3lan93:android-versioning-manager:<latest version>")
  }
}

apply(plugin = "com.github.sh3lan93.android-version-manager")
```
</details>
Replace latest version with the version number
  
<details>
  <summary>Groovy</summary>

```groovy
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "com.github.sh3lan93:android-versioning-manager:<latest version>"
  }
}

apply plugin: "com.github.sh3lan93.android-version-manager"
```
</details>
Replace latest version with the version number

### Roadmap
  - [x] version code 
  - [ ] version name 
