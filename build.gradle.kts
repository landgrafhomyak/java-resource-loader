plugins {
    java
    kotlin("jvm") version "1.9.0"
    `maven-publish`
}


repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    // withJavadocJar()
    withSourcesJar()
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
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "ru.landgrafhomyak.utility"
            artifactId = "java-resource-loader"
            version = "2.0"

            from(components["java"])

            pom {
                packaging = "jar"
                name.set("Utility functions for Java resource loading")
                // url.set("https://maven.landgrafhomyak.ru/ru/landgrafhomyak/utility/java-resource-loader/")
            }
        }
    }
}