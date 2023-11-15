plugins {
    java
    kotlin("jvm") version "1.9.0"
    `maven-publish`
}

group = "ru.landgrafhomyak.utility"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_1
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

kotlin {
    target {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                compileOnly(kotlin("stdlib"))
            }
        }
    }
}