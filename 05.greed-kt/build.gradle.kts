val kotlinVersion: String by project
val kotestVersion: String by project

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "com.example"
version = "0.0.1"

repositories {
    mavenCentral()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
}